package com.maybetm.julie.csv.processor;

import com.maybetm.julie.csv.deserializer.annotations.JulieCsvColumn;
import com.maybetm.julie.csv.deserializer.annotations.JulieCsvDeserializer;

import java.util.Calendar;

/**
 * @author zebzeev-sv
 * @version 23.05.2020 3:08
 */
public class CsvData
{

  @JulieCsvDeserializer(using = JulieDeserializerImpl.class)
  public Long id;

  @JulieCsvColumn (position = 1, fieldName = "secondId")
  public Integer secondId;

  @JulieCsvColumn (position = 2, fieldName = "name")
  public String name;

  @JulieCsvDeserializer(using = CalendarDes.class)
  public Calendar date;


  @Override
  public String toString()
  {

    return "CsvData{" +
           "id=" + id +
           ", secondId=" + secondId +
           ", name='" + name + '\'' +
           ", date=" + (date != null ? date.getTime() : null )+
           '}';
  }
}
