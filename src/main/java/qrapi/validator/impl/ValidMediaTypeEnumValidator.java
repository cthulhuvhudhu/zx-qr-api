package qrapi.validator.impl;

import qrapi.rest.MediaTypeEnum;
import qrapi.validator.ValidMediaTypeEnum;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidMediaTypeEnumValidator implements ConstraintValidator<ValidMediaTypeEnum, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            MediaTypeEnum.valueOf(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
