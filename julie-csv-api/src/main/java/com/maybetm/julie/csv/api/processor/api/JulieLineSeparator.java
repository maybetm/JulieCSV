package com.maybetm.julie.csv.api.processor.api;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zebzeev-sv
 * @version 23.05.2020 16:28
 */
public interface JulieLineSeparator
{

  String[] split(String line);

  JulieLineSeparator defaultSeparator = (line) -> StringUtils.split(line, "|");

  static JulieLineSeparator createLineSeparator(String separator)
  {
    return s -> StringUtils.split(s, separator);
  }
}
