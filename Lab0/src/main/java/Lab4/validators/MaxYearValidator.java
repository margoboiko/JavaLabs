package Lab4.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class MaxYearValidator implements ConstraintValidator<MaxYear, LocalDate> {
    private int allowedYear;

    @Override
    public void initialize(MaxYear maxYear) {
        allowedYear = maxYear.value();
    }

    @Override
    public boolean isValid(LocalDate dateBirth, ConstraintValidatorContext context) {
        return dateBirth.getYear() > allowedYear;
    }
}
