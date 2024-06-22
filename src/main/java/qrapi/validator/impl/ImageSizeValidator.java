package qrapi.validator.impl;

import qrapi.validator.ImageSize;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ImageSizeValidator implements ConstraintValidator<ImageSize, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && value >= 150 && value <= 350;
    }
}
