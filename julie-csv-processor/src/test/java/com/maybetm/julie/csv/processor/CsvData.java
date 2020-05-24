package com.maybetm.julie.csv.processor;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.maybetm.julie.csv.deserializer.CalendarDeserializer;
import com.maybetm.julie.csv.deserializer.annotations.JulieCsvColumn;

import java.util.Calendar;

/**
 * @author zebzeev-sv
 * @version 23.05.2020 3:08
 */
public class CsvData
{

  @JulieCsvColumn (position = 0, fieldName = "id")
  public Long id;

  @JulieCsvColumn (position = 1, fieldName = "secondId")
  public Integer secondId;

  @JulieCsvColumn (position = 2, fieldName = "name")
  public String name;

  @JsonDeserialize (using = CalendarDeserializer.class)
  public Calendar date;


  @Override
  public String toString()
  {
    return "CsvData{" +
           "id=" + id +
           ", secondId=" + secondId +
           ", name='" + name + '\'' +
           ", date=" + date.getTime()+
           '}';
  }
}
