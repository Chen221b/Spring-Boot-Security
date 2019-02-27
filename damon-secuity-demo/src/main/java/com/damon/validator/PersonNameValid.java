package com.damon.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PersonNameConstraint.class)
public @interface PersonNameValid {
    String message() default "name valid failed";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
