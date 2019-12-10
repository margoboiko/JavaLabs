package Lab4.validators;

import Lab4.validators.MaxYearValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = MaxYearValidator.class)
public @interface MaxYear {

    String message() default "{Incorrect birth date}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default  {};
    int value();
}