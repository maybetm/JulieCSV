package com.maybetm.julie.csv.processor.api;

/**
 * @author zebzeev-sv
 * @version 23.05.2020 2:53
 */
public interface JulieCsvPreprocessor<T>
{

  void process(T data) throws Throwable;
}
