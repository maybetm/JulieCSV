package com.maybetm.julie.csv.api.validation.exception;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author zebzeev-sv
 * @version 05.06.2020 23:38
 */
public class JulieCsvErrorInfo
{

  public final long lineIndex;

  public final int fieldId;

  public final String fieldName;

  public JulieCsvErrorInfo(long lineIndex, int fieldId, String fieldName)
  {
    this.lineIndex = lineIndex;
    this.fieldId = fieldId;
    this.fieldName = fieldName;
  }
}
