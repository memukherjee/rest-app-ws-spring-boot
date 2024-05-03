package com.example.restappws.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
public @interface ValidEmail {
    String message() default "Invalid Email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
