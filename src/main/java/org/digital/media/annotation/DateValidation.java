package org.digital.media.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidation implements ConstraintValidator<DateValidator, String> {

    private final DateTimeFormatter dateTimeFormatter;

    public DateValidation(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

//    @Override
//    public void initialize(DateValidator constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
//    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            this.dateTimeFormatter.parse(value);
        } catch (DateTimeParseException ex) {
            return false;
        }
        return true;
    }
}
