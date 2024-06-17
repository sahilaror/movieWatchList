package com.example.demo.curds.entity.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ratingLogic implements ConstraintValidator<Rating, Float>{

	@Override
	public boolean isValid(	Float value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return value>5 && value<=10;
	}

}
