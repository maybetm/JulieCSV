package com.maybetm.julie.csv.api.deserialize.annotations;

import com.maybetm.julie.csv.api.deserialize.api.JulieDeserializer;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zebzeev-sv
 * @version 25.05.2020 17:20
 */
@Documented
@Target ({ElementType.FIELD})
@Retention (RetentionPolicy.RUNTIME)
public @interface JulieCsvDeserializer
{
  Class<? extends JulieDeserializer<?, ?>> using();

}
