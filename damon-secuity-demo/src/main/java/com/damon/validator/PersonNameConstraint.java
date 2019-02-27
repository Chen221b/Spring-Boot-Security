package com.damon.validator;

import com.damon.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PersonNameConstraint implements ConstraintValidator<PersonNameValid, String> {

    @Autowired
    PersonService service = null;

    @Override
    public void initialize(PersonNameValid constraintAnnotation) {
        System.out.println("Init: " + this.getClass().getName());
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return !service.isPersonExist(name);
    }
}
