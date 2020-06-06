package com.maybetm.julie.csv.api.impl.processor;

import com.maybetm.julie.csv.api.deserialize.api.JulieCsvBeanDeserializer;
import com.maybetm.julie.csv.api.processor.api.JulieCsvPostProcessor;
import com.maybetm.julie.csv.api.processor.api.JulieCsvPreprocessor;
import com.maybetm.julie.csv.api.processor.api.JulieLineSeparator;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.List;

/**
 * @author zebzeev-sv
 * @version 23.05.2020 2:13
 */
public class JulieCsvProcessor<T>
{

  private final List<JulieCsvPreprocessor> preProcessors;
  private final List<JulieCsvPostProcessor<T>> postProcessors;

  private final JulieLineSeparator lineSeparator;
  private final JulieCsvBeanDeserializer<T> deserializer;

  public JulieCsvProcessor(JulieCsvBeanDeserializer<T> deserializer, JulieLineSeparator lineSeparator,
                           List<JulieCsvPreprocessor> preProc, List<JulieCsvPostProcessor<T>> postProc)
  {
    this.deserializer = deserializer;
    this.preProcessors = preProc;
    this.postProcessors = postProc;
    this.lineSeparator = lineSeparator;
  }

  /**
   * Start csv file processing
   *
   * @param reader - file input stream
   * @param lineStartProcessing - start processing from line
   * @param beanCsv - class name of deserialize
   * @throws Throwable - fixme add normal exception
   *
   * @return - count lina processing
   */
  public long process(Reader reader, long lineStartProcessing, Class<T> beanCsv) throws Throwable
  {
    try (BufferedReader br = new BufferedReader(reader)) {
      long currentLinePosition = 0;
      String line;

      // read for skip lines
      while (lineStartProcessing > currentLinePosition++)
        br.readLine();

      while ((line = br.readLine()) != null) {
        preProcessor(line, currentLinePosition);

        String[] lineByColumns = lineSeparator.split(line);
        T data = deserializer.deserialize(lineByColumns, beanCsv);

        postProcessor(data, currentLinePosition);
        ++currentLinePosition;
      }

      return currentLinePosition;
    }
  }

  private void preProcessor(String line, long currentLinePosition) throws Throwable
  {
    if (preProcessors != null && !preProcessors.isEmpty())
      for (JulieCsvPreprocessor preps : preProcessors) {
        preps.process(line, currentLinePosition);
      }
  }

  private void postProcessor(T data, long currentLinePosition) throws Throwable
  {
    if (postProcessors != null && !postProcessors.isEmpty())
      for (JulieCsvPostProcessor<T> posts : postProcessors) {
        posts.process(data, currentLinePosition);
      }
  }
}
