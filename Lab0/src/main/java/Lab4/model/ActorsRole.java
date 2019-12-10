package Lab4.model;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

public class ActorsRole implements Comparable<ActorsRole> {

    @NotNull
    private Actors actor;
    @Size(min = 2, max = 20, message = "Incorrect role")
    private String role;

    public Actors getActor() {
        return actor;
    }
    public void setActor(Actors actor) {
        if (actor == null)
            throw new RuntimeException("Please add actors!");
        this.actor = actor;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        if (role.length() > 20)
            throw new RuntimeException("Please rewrite!");
        this.role = role;
    }

    @Override
    public String toString() {
        return "ActorsRole{" +
                "actor=" + actor +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorsRole that = (ActorsRole) o;
        return Objects.equals(actor, that.actor) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor, role);
    }

    @Override
    public int compareTo(ActorsRole actorsRole) {
        return 0;
    }

    /**
     *
     * inner class builder which implements
     * pattern "Builder"
     */
    public class Builder {

        public Builder() {
        }

        public ActorsRole.Builder addActor(Actors actor) {
            ActorsRole.this.actor = actor;
            return this;
        }

        /**
         *
         * @param role lenght must be less than 20
         * @return instance of this builder
         */
        public ActorsRole.Builder setRole(String role) {
            ActorsRole.this.role = role;
            return this;
        }

        /**
         * Call it after setting all parameters
         * @return instance of class Actors
         */
        public ActorsRole build() {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<ActorsRole>> constraintViolations = validator.validate(ActorsRole.this);

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

            return ActorsRole.this;
        }

    }
}

