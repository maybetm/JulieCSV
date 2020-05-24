package com.maybetm.julie.csv.deserializer.api;

/**
 * @author zebzeev-sv
 * @version 23.05.2020 2:57
 */
public interface JulieCsvBeanDeserializer<T>
{

  T deserialize(String[] line, Class<? extends T> beanCsv);
}
