package com.maybetm.julie.csv.api.processor.api;

/**
 * @author zebzeev-sv
 * @version 23.05.2020 2:53
 */
public interface JulieCsvPreprocessor
{

  void process(String line, long currentLinePosition) throws Throwable;
}
