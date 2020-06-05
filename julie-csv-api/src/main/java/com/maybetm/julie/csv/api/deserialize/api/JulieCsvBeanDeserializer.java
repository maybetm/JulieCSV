package com.maybetm.julie.csv.api.deserialize.api;

import java.lang.reflect.InvocationTargetException;

/**
 * @author zebzeev-sv
 * @version 23.05.2020 2:57
 */
public interface JulieCsvBeanDeserializer<T>
{

  T deserialize(String[] line, Class<? extends T> beanCsv) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;
}
