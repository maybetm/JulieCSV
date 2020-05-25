package com.maybetm.julie.csv.processor;

import com.maybetm.julie.csv.deserializer.CsvBeanDeserializer;
import com.maybetm.julie.csv.processor.api.JulieLineSeparator;
import com.maybetm.julie.csv.validator.CsvBeanValidator;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author zebzeev-sv
 * @version 23.05.2020 17:45
 */
class JulieCsvProcessorTest
{

  private static final String pathFile =  ClassLoader.getSystemResource("test.csv").getPath();

  @Test
  void parse() throws Throwable
  {
    CsvBeanDeserializer<CsvData> deserializer = new CsvBeanDeserializer<>();
    JulieLineSeparator separator = JulieLineSeparator.defaultSeparator;
    CsvBeanValidator<CsvData> validator = new CsvBeanValidator<CsvData>();

    JulieCsvProcessor<CsvData> julieCsvParser = new JulieCsvProcessor<CsvData>(deserializer, validator, separator, null, null);

    julieCsvParser.process(getInputStreamReader(), 0, CsvData.class);
  }

  private InputStreamReader getInputStreamReader() throws FileNotFoundException
  {
    return new InputStreamReader(new FileInputStream(pathFile), StandardCharsets.UTF_8);
  }
}