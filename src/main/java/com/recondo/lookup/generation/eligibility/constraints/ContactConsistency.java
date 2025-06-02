package com.recondo.lookup.generation.eligibility.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * This annotation is used to drive a class level validation on the Contact class.
 * 
 * @author David.Cannon
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ContactConsistencyValidator.class)
@Documented
public @interface ContactConsistency {
	String message() default "Value '${validatedValue}' is not a valid Contact";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
