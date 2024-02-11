package org.example;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;

import java.util.Set;
import java.util.stream.Collectors;

public class Body2PassValidator implements ConstraintValidator<ConsistentBody2Pass, Body2Pass> {

    @Override
    public boolean isValid(
            Body2Pass value,
            ConstraintValidatorContext context) {

        Set<ConstraintViolation<Body2Pass>> constraintViolations = Validation.buildDefaultValidatorFactory().getValidator()
                .validate(value);
        if (constraintViolations.isEmpty()) {
            return true;
        }

        context.buildConstraintViolationWithTemplate(constraintViolations.stream().map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(";"))).addConstraintViolation();

        return false;
    }
}