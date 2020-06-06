package com.maybetm.julie.csv.api.validation.exception;

/**
 * @author zebzeev-sv
 * @version 05.06.2020 23:37
 */
public class ValidateException extends Exception
{

  private final JulieCsvErrorInfo julieCsvErrorInfo;

  public ValidateException(Throwable cause)
  {
    this(null, null, cause);
  }

  public ValidateException(JulieCsvErrorInfo julieCsvErrorInfo, String message)
  {
    this(julieCsvErrorInfo, message, null);
  }

  public ValidateException(String message, Throwable cause)
  {
    this(null, message, cause);
  }

  public ValidateException(JulieCsvErrorInfo julieCsvErrorInfo, String message, Throwable cause)
  {
    super(message, cause);
    this.julieCsvErrorInfo = julieCsvErrorInfo;
  }

  public JulieCsvErrorInfo getJulieCsvErrorInfo()
  {
    return julieCsvErrorInfo;
  }
}
