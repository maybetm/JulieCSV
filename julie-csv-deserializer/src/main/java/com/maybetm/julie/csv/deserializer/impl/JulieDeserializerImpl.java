package com.maybetm.julie.csv.deserializer.impl;

import com.maybetm.julie.csv.deserializer.api.JulieDeserializer;

/**
 * @author zebzeev-sv
 * @version 25.05.2020 18:31
 */
public class JulieDeserializerImpl implements JulieDeserializer<Long, Object>
{

  @Override
  public Long deserialize(String data, Class<? extends Object> beanCsv)
  {
    return Long.valueOf(data);
  }
}
