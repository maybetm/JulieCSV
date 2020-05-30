package com.maybetm.julie.csv.validator.api;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author zebzeev-sv
 * @version 30.05.2020 23:19
 */
public interface JulieFieldValidator<T>
{

  Set<ConstraintViolation<T>> validate(T object, String propertyName, Class<?>... groups) throws Exception;

}
