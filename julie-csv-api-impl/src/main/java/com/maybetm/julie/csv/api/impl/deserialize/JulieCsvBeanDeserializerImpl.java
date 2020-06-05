package com.maybetm.julie.csv.api.impl.deserialize;

import com.maybetm.julie.csv.api.deserialize.annotations.JulieCsvDeserializer;
import com.maybetm.julie.csv.api.deserialize.api.JulieCsvBeanDeserializer;
import com.maybetm.julie.csv.api.deserialize.api.JulieDeserializer;
import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zebzeev-sv
 * @version 23.05.2020 18:16
 */
public class JulieCsvBeanDeserializerImpl<T> implements JulieCsvBeanDeserializer<T>
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

  // todo тут можно получить исключение с колонкой, наименованием поля
  private void configurer(T data, String[] line) throws IllegalAccessException, InstantiationException
  {
    Field[] fields = data.getClass().getFields();

    for (int cell = 0; cell < line.length; cell++) {
      JulieCsvDeserializer deserializer = fields[cell].getAnnotation(JulieCsvDeserializer.class);
      if (deserializer != null) {
        JulieDeserializer deserializers = deserializer.using().newInstance();
        fields[cell].set(data, deserializers.deserialize(line[cell], data));
      } else {
        fields[cell].set(data, ConvertUtils.convert(line[cell], fields[cell].getType()));
      }
    }
  }
}
