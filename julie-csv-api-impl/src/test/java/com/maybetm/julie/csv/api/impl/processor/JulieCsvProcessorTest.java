package com.maybetm.julie.csv.api.impl.processor;

import com.maybetm.julie.csv.api.common.CsvData;
import com.maybetm.julie.csv.api.impl.deserialize.JulieCsvBeanDeserializerImpl;
import com.maybetm.julie.csv.api.processor.api.JulieLineSeparator;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author zebzeev-sv
 * @version 04.06.2020 0:49
 */
class JulieCsvProcessorTest
{

  private static final String pathFile =  ClassLoader.getSystemResource("test_csv_file.csv").getPath();

  @Test
  void parse() throws Throwable
  {
    JulieCsvBeanDeserializerImpl<CsvData> deserializer = new JulieCsvBeanDeserializerImpl<>();
    JulieLineSeparator separator = JulieLineSeparator.defaultSeparator;

    JulieCsvProcessor<CsvData> julieCsvParser = new JulieCsvProcessor<>(deserializer, null, separator, null, null);

    julieCsvParser.process(getInputStreamReader(), 0, CsvData.class);
  }

  private InputStreamReader getInputStreamReader() throws FileNotFoundException
  {
    return new InputStreamReader(new FileInputStream(pathFile), StandardCharsets.UTF_8);
  }
}
