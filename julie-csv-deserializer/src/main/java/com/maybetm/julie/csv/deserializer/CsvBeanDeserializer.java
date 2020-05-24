package com.maybetm.julie.csv.deserializer;

import com.maybetm.julie.csv.deserializer.api.JulieCsvBeanDeserializer;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author zebzeev-sv
 * @version 23.05.2020 18:16
 */
public class CsvBeanDeserializer<T> implements JulieCsvBeanDeserializer<T>
{

  @Override
  public T deserialize(String[] line, Class<? extends T> beanCsv)
  {
    try {
      Field field = beanCsv.getField("id");

    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }

    System.out.println(Arrays.toString(line));
    return null;
  }
}
