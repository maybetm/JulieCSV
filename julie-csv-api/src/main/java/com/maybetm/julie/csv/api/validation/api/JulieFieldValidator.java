package com.maybetm.julie.csv.api.validation.api;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author zebzeev-sv
 * @version 30.05.2020 23:19
 */
public interface JulieFieldValidator<T>
{

  Set<ConstraintViolation<T>> validate(T object, String propertyName, Class<?>... groups);

  static <T> JulieFieldValidator<T> defaultFieldValidator()
  {
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    return validator::validateProperty;
  }

}
