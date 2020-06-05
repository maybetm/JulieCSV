package com.maybetm.julie.csv.api.common;

import com.maybetm.julie.csv.api.deserialize.annotations.JulieCsvDeserializer;
import com.maybetm.julie.csv.api.deserialize.api.impl.JulieImplCalendarDeserialize;
import com.maybetm.julie.csv.api.deserialize.api.impl.JulieImplLongDeserialize;

import java.util.Calendar;

/**
 * @author zebzeev-sv
 * @version 05.06.2020 13:36
 */
public class CsvData
{
  @JulieCsvDeserializer (using = JulieImplLongDeserialize.class)
  public Long id;

  public Integer secondId;

  public String name;

  @JulieCsvDeserializer(using = JulieImplCalendarDeserialize.class)
  public Calendar date;

  @Override
  public String toString()
  {
    return "CsvData{" +
           "id=" + id +
           ", secondId=" + secondId +
           ", name='" + name + '\'' +
           ", date=" + (date != null ? date.getTime() : null)+
           '}';
  }
}
