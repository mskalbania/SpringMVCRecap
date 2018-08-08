package edu.mvc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUser {
    String message() default "Something went wrong.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
