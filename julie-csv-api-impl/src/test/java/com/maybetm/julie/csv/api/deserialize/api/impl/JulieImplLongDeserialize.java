package com.maybetm.julie.csv.api.deserialize.api.impl;

import com.maybetm.julie.csv.api.common.CsvData;
import com.maybetm.julie.csv.api.deserialize.api.JulieDeserializer;

/**
 * @author zebzeev-sv
 * @version 25.05.2020 18:31
 */
public class JulieImplLongDeserialize implements JulieDeserializer<Long, CsvData>
{
  @Override
  public Long deserialize(String data, CsvData beanCsv)
  {
    return Long.valueOf(data);
  }
}
