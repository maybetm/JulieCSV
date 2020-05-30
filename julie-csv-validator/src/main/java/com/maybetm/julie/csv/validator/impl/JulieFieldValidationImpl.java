package com.maybetm.julie.csv.validator.impl;

import com.maybetm.julie.csv.validator.api.JulieFieldValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author zebzeev-sv
 * @version 31.05.2020 0:28
 */
public class JulieFieldValidationImpl<T> implements JulieFieldValidator<T>
{

  private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  @Override
  public Set<ConstraintViolation<T>> validate(T object, String propertyName, Class<?>... groups) throws Exception
  {
    return this.validator.validateProperty(object, propertyName, groups);
  }
}
