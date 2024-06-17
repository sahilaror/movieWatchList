package com.example.demo.curds.entity.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class priorityLogic implements ConstraintValidator<priority, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return value.trim().length()==1 && "lmh".contains(value.trim());
	}

	
}
