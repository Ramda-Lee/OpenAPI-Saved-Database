package com.fpr.annotation;

import com.fpr.annotation.validator.TelValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TelValidator.class)
public @interface Tel {
    String message() default "";
    Class[] groups() default {};
    Class[] payload() default {};
}
