package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotations;

import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation,String>{

	@Override
	public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
		if(inputRole == null) return false;
        List<String> roles = List.of("USER", "ADMIN");
        return roles.contains(inputRole);
	}

}
