package com.quyen.ch10.converter;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = NameValidator.class)
@Documented
public @interface CheckName {
    String message() default "Name must have 2 characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
