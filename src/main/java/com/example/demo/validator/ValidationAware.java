package com.example.demo.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.Set;

@SuppressWarnings("unchecked")
public abstract class ValidationAware<T> {

    private final Validator validator;

    protected ValidationAware() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public void validate() {
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
