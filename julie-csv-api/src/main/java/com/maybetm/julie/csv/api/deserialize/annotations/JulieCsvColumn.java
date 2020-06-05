package com.maybetm.julie.csv.api.deserialize.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zebzeev-sv
 * @version 23.05.2020 18:18
 */
@Documented
@Target ({ElementType.FIELD})
@Retention (RetentionPolicy.RUNTIME)
public @interface JulieCsvColumn
{

  int position();

  String fieldName() default "";
}
