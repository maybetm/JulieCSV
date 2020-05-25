package com.maybetm.julie.csv.deserializer;

import com.maybetm.julie.csv.deserializer.annotations.JulieCsvDeserializer;
import com.maybetm.julie.csv.deserializer.api.JulieCsvBeanDeserializer;
import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zebzeev-sv
 * @version 23.05.2020 18:16
 */
public class CsvBeanDeserializer<T> implements JulieCsvBeanDeserializer<T>
{

  @Override
  public T deserialize(String[] line, Class<? extends T> beanCsv) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
  {

    T data = createObject(beanCsv);

    configurer(data, line);

    System.out.println(data.toString());
    return data;
  }

  private T createObject(Class<? extends T> beanCsv) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    return beanCsv.getDeclaredConstructor().newInstance();
  }

  private void configurer(T data, String[] line) throws IllegalAccessException, InstantiationException
  {
    Field[] fields = data.getClass().getFields();

    for (int cell = 0; cell < line.length; cell++) {
      JulieCsvDeserializer deserializer = fields[cell].getAnnotation(JulieCsvDeserializer.class);
      if (deserializer != null) {
        fields[cell].set(data, deserializer.using().newInstance().deserialize(line[cell], data.getClass()));
      } else {
        fields[cell].set(data, ConvertUtils.convert(line[cell], fields[cell].getType()));
      }
    }
  }
}
