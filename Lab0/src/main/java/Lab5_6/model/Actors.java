package Lab5_6.model;

import Lab2.service.LocalDateDeserializer;
import Lab2.service.LocalDateSerializer;
import Lab4.validators.MaxYear;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Actors implements Serializable {

    @NotNull
    @Size(min = 2, max = 20, message = "Incorrect name")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30, message = "Incorrect surname")
    private String lastName;

    @JsonFormat(pattern = "yyyyMMdd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @MaxYear(1960)
    private LocalDate birthday;

    @Min(3000)
    private Double salary;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }



    @Override
    public String toString() {
        return "Actors{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actors actors = (Actors) o;
        return Objects.equals(firstName, actors.firstName) &&
                Objects.equals(lastName, actors.lastName) &&
                Objects.equals(birthday, actors.birthday) &&
                Objects.equals(salary, actors.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthday, salary);
    }

    /**
     * inner class builder which implements
     * pattern "Builder"
     */
    public class Builder {

        public Builder() {
            // private constructor
        }

        public Actors.Builder setFirstName(String firstName) {
            Actors.this.firstName = firstName;
            return this;
        }

        public Actors.Builder setLastName(String lastName) {
            Actors.this.lastName = lastName;
            return this;
        }

        /**
         *
         * @param birthday LocalDate must be less than MAXYEAR
         * @return instance of this builder
         */
        public Actors.Builder setBirthday(LocalDate birthday) {
            Actors.this.birthday = birthday;
            return this;
        }

        /**
         *
         * @param salary Double must be more than MINSALARY
         * @return instance of this builder
         */
        public Actors.Builder setSalary(Double salary) {
                Actors.this.salary = salary;
            return this;
        }

        /**
         * Call it after setting all parameters
         * @return instance of class Actors
         */
        public Actors build() {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Actors>> constraintViolations = validator.validate(Actors.this);

            if(!constraintViolations.isEmpty()) {
                StringBuilder str = new StringBuilder();
                constraintViolations .forEach(constraint -> {
                    str.append(constraint.getPropertyPath())
                            .append(" : ")
                            .append(constraint.getMessage())
                            .append("\n");
                });
                throw new RuntimeException(str.toString());
            }
            return Actors.this;
        }

    }
}