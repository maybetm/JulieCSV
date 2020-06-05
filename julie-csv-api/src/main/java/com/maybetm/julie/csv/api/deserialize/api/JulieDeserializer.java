package com.maybetm.julie.csv.api.deserialize.api;

/**
 * @author zebzeev-sv
 * @version 25.05.2020 18:17
 */
public interface  JulieDeserializer<T, B>
{

  T deserialize(String data, B beanCsv);

}
