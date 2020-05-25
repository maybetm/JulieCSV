package com.maybetm.julie.csv.processor;

import com.maybetm.julie.csv.deserializer.api.JulieCsvBeanDeserializer;
import com.maybetm.julie.csv.processor.api.JulieCsvPostProcessor;
import com.maybetm.julie.csv.processor.api.JulieCsvPreprocessor;
import com.maybetm.julie.csv.processor.api.JulieLineSeparator;
import com.maybetm.julie.csv.validator.api.JulieCsvBeanValidator;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.List;

/**
 * @author zebzeev-sv
 * @version 23.05.2020 2:13
 */
public class JulieCsvProcessor<T>
{

  private final List<JulieCsvPreprocessor<T>> preProcessors;
  private final List<JulieCsvPostProcessor<T>> postProcessors;

  private final JulieLineSeparator lineSeparator;
  private final JulieCsvBeanDeserializer<T> deserializer;
  private final JulieCsvBeanValidator<T> validator;

  public JulieCsvProcessor(JulieCsvBeanDeserializer<T> deserializer, JulieCsvBeanValidator<T> validator,
                           JulieLineSeparator lineSeparator, List<JulieCsvPreprocessor<T>> preProc,
                           List<JulieCsvPostProcessor<T>> postProc)
  {
    this.deserializer = deserializer;
    this.validator = validator;
    this.preProcessors = preProc;
    this.postProcessors = postProc;
    this.lineSeparator = lineSeparator;
  }

  public long process(Reader reader, int lineStartProcessing, Class<T> beanCsv) throws Throwable
  {
    try (BufferedReader br = new BufferedReader(reader)) {
      long currentLinePosition = 0;
      String line;

      while ((line = br.readLine()) != null) {
        if (currentLinePosition < lineStartProcessing) {
          ++currentLinePosition;
          continue;
        }

        if(line.isEmpty())
          continue;

        String[] lineByColumns = lineSeparator.split(line);
        T data = deserializer.deserialize(lineByColumns, beanCsv);

        preProcessor(data);
        validator.validate(data);
        postProcessor(data);

        ++currentLinePosition;
      }

      return currentLinePosition;
    }
  }

  private void preProcessor(T data) throws Throwable
  {
    if (preProcessors != null && !preProcessors.isEmpty())
      for (JulieCsvPreprocessor<T> preps : preProcessors) {
        preps.process(data);
      }
  }

  private void postProcessor(T data) throws Throwable
  {
    if (postProcessors != null && !postProcessors.isEmpty())
      for (JulieCsvPostProcessor<T> posts : postProcessors) {
        posts.process(data);
      }
  }
}