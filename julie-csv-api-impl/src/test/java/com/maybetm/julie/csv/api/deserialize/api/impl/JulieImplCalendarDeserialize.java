package com.maybetm.julie.csv.api.deserialize.api.impl;

import com.maybetm.julie.csv.api.common.CsvData;
import com.maybetm.julie.csv.api.deserialize.api.JulieDeserializer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author zebzeev-sv
 * @version 05.06.2020 13:47
 */
public class JulieImplCalendarDeserialize implements JulieDeserializer<Calendar, CsvData>
{

  @Override
  public Calendar deserialize(String data, CsvData beanCsv)
  {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
    try {
      cal.setTime(sdf.parse(data));
    } catch (ParseException e) {
      cal = null;
    }

    return cal;
  }
}
