package com.example.demo.curds.entity.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ratingLogic.class)
public @interface Rating {
	String message() default "please use value between 5-10";
	Class<?>[]groups() default{};
	Class<? extends Payload>[] payload() default{};
}
