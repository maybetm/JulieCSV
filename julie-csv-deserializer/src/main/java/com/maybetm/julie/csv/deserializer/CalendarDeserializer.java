package com.maybetm.julie.csv.deserializer;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarDeserializer extends JsonDeserializer<Calendar>
{

  @Override
  public Calendar deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException
  {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hhmm:ss");
    try {
      cal.setTime(sdf.parse(jp.getText()));// all done
    } catch (ParseException e) {
      cal = null;
    }
    return cal;
  }
}
