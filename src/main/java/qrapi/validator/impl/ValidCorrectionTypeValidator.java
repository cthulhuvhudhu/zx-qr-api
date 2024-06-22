package qrapi.validator.impl;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import qrapi.validator.ValidCorrectionEnum;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCorrectionTypeValidator implements ConstraintValidator<ValidCorrectionEnum, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            ErrorCorrectionLevel.valueOf(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
