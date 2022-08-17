package com.likebookapp.util;

import com.likebookapp.model.dto.UserRegistrationDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EqualPasswordsConstraintValidator implements ConstraintValidator<EqualPasswordsConstraint, Object> {
    @Override
    public void initialize(EqualPasswordsConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object candidate, ConstraintValidatorContext context) {
        UserRegistrationDTO registerDto = (UserRegistrationDTO) candidate;
        return registerDto.getPassword().equals(registerDto.getConfirmPassword() );
    }
}
