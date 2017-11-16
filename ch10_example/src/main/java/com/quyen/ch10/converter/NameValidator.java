package com.quyen.ch10.converter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.AssertTrue;

public class NameValidator implements ConstraintValidator<CheckName, VietnameseName> {
    @Override
    public void initialize(CheckName checkName) {

    }

    @Override
    public boolean isValid(VietnameseName vietnameseName, ConstraintValidatorContext constraintValidatorContext) {
        if (vietnameseName.getTen().length() < 2)
            return false;
        return true;
    }
}
