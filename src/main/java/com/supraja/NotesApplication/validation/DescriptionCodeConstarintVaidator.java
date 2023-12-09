package com.supraja.NotesApplication.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DescriptionCodeConstarintVaidator implements ConstraintValidator<DescriptionCode, String> {

    private String descriptionPrefix;
    @Override
    public void initialize(DescriptionCode theDescriptionCode) {
        descriptionPrefix = theDescriptionCode.value();
    }

    @Override
    public boolean isValid(String theDescription, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if (descriptionPrefix !=null) {
            result = theDescription.startsWith(descriptionPrefix);
        }
        else {
            result = true;
        }
        return result;
    }
}
