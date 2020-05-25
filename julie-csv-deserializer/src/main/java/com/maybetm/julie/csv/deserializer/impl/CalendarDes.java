package com.maybetm.julie.csv.deserializer.impl;

import com.maybetm.julie.csv.deserializer.api.JulieDeserializer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author zebzeev-sv
 * @version 25.05.2020 21:14
 */
public class CalendarDes implements JulieDeserializer<Calendar, Object>
{

  @Override
  public Calendar deserialize(String data, Class<? extends Object> beanCsv)
  {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
    try {
      cal.setTime(sdf.parse(data));// all done
    } catch (ParseException e) {
      cal = null;
    }

    return cal;
  }
}
