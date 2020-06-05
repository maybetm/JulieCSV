package com.maybetm.julie.csv.api.validation.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author zebzeev-sv
 * @version 05.06.2020 14:12
 */
class JulieFieldValidatorTest
{
  @Test
  void validate() throws Exception
  {
    CsvData testValidateClass = new CsvData("", null);
    JulieFieldValidator<CsvData> fieldValidation = JulieFieldValidator.defaultFieldValidator();

    Assertions.assertEquals(1, fieldValidation.validate(testValidateClass, "name").size());
  }

  private static class CsvData
  {

    @Size (min = 2, message = "Поле \"name\" не может содержать данное значение")
    String name;
    @NotNull
    Integer i1;

    CsvData(String name, @Size (min = 2) Integer i1)
    {
      this.name = name;
      this.i1 = i1;
    }
  }
}
