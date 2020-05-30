package com.maybetm.julie.csv.validator;

import com.maybetm.julie.csv.validator.impl.JulieFieldValidationImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author zebzeev-sv
 * @version 30.05.2020 23:23
 */
class JulieFieldValidationImplTest
{

  @Test
  void validate() throws Exception
  {
    TestValidateClass testValidateClass = new TestValidateClass("", null);
    JulieFieldValidationImpl<TestValidateClass> fieldValidation = new JulieFieldValidationImpl<>();

    Assertions.assertEquals(1, fieldValidation.validate(testValidateClass, "name").size());
  }

  static class TestValidateClass
  {

    @Size (min = 2, message = "Поле i1 не может содержать данное значение")
    String name;
    @NotNull
    Integer i1;

    TestValidateClass(String name, @Size (min = 2) Integer i1)
    {
      this.name = name;
      this.i1 = i1;
    }
  }
}
