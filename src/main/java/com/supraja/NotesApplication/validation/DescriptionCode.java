package com.supraja.NotesApplication.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DescriptionCodeConstarintVaidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DescriptionCode {

    public String value() default "NOTE";

    public String message() default "description should start with NOTE";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
