package com.recondo.lookup.generation.eligibility.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.recondo.lookup.generation.eligibility.parts.Contact;

/**
 * For a Contact object, this validator makes sure that for each of the number/qualifier pairs, 
 * they are either both null or both not null.
 * 
 * @author David.Cannon
 */
public class ContactConsistencyValidator implements ConstraintValidator<ContactConsistency, Contact> {
	@Override
	public void initialize(ContactConsistency constraintAnnotation) {
		// Intentionally left blank
	}

	@Override
	public boolean isValid(Contact contact, ConstraintValidatorContext constraintContext) {
		boolean valid = false;

		if (((contact.getContactNum1() != null && contact.getContactNumQlfr1() != null) 
				|| (contact.getContactNum1() == null && contact.getContactNumQlfr1() == null)) 
			&& ((contact.getContactNum2() != null && contact.getContactNumQlfr2() != null) 
					|| (contact.getContactNum2() == null && contact.getContactNumQlfr2() == null)) 
			&& ((contact.getContactNum3() != null && contact.getContactNumQlfr3() != null) 
					|| (contact.getContactNum3() == null && contact.getContactNumQlfr3() == null))) {
			valid = true;
		}

		if (!valid) {
			if ((contact.getContactNum1() == null && contact.getContactNumQlfr1() != null)
					|| (contact.getContactNum1() != null && contact.getContactNumQlfr1() == null)) {
				constraintContext.disableDefaultConstraintViolation();
				constraintContext.buildConstraintViolationWithTemplate("Contact number 1 not consistent with qualifier").addPropertyNode("contactNum1")
						.addConstraintViolation();
			}
			if ((contact.getContactNum2() == null && contact.getContactNumQlfr2() != null)
					|| (contact.getContactNum2() != null && contact.getContactNumQlfr2() == null)) {
				constraintContext.disableDefaultConstraintViolation();
				constraintContext.buildConstraintViolationWithTemplate("Contact number 2 not consistent with qualifier").addPropertyNode("contactNum2")
						.addConstraintViolation();
			}
			if ((contact.getContactNum3() == null && contact.getContactNumQlfr3() != null)
					|| (contact.getContactNum3() != null && contact.getContactNumQlfr3() == null)) {
				constraintContext.disableDefaultConstraintViolation();
				constraintContext.buildConstraintViolationWithTemplate("Contact number 3 not consistent with qualifier").addPropertyNode("contactNum3")
						.addConstraintViolation();
			}
		}

		return valid;
	}
}
