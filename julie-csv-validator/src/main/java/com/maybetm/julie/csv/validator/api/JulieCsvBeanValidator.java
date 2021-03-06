package com.maybetm.julie.csv.validator.api;

/**
 * @author zebzeev-sv
 * @version 23.05.2020 3:03
 */
public interface JulieCsvBeanValidator<T>
{

  void validate(T data) throws Throwable;
}
