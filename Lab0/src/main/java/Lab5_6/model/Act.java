package Lab5_6.model;

import Lab4.model.ActorsRole;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Act {

    public static final Integer MAX_NAME_LENGTH = 30;
    @NotNull
    @Size(min =2, max = 30, message="Incorrect name")
    private String name;
    @NotNull
    @Size(min =2, max = 20, message="Incorrect genre")
    private String genre;
    @Size(min =1, max = 20, message="Incorrect roles count")
    private List<ActorsRole> roles = new ArrayList<>();

    public Act(String name, String genre, List<ActorsRole> roles) {
        this.name = name;
        this.genre = genre;
        this.roles = roles;

    }

    public Act() {

    }

    public String getName() {
        return name;
    }

    /**
     * @param name Act name
     */
    public void setName(String name) {
        if (name.length() > MAX_NAME_LENGTH)
            throw new RuntimeException("Please rewrite!");
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    /**
     * @param genre Act genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<ActorsRole> getActorsRole() {
        return roles;
    }

    public void setRoles(List<ActorsRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Act{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Act act = (Act) o;
        return Objects.equals(name, act.name) &&
                Objects.equals(genre, act.genre) &&
                Objects.equals(roles, act.roles);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, genre, roles);
    }

    /**
     * inner class builder which implements
     * pattern "Builder"
     */
    public static class Builder {

        Act act;

        public Builder() {
            act = new Act();
        }

        /**
         * @param name String must be less than MAXNAMELENGHT
         * @return instance of this builder
         */
        public Builder setName(String name) {
            act.setName(name);
            if (name.length() > MAX_NAME_LENGTH)
                throw new RuntimeException("Please rewrite!");
            else
                act.name = name;
            return this;
        }

        public Builder setGenre(String genre) {
            act.genre = genre;
            return this;
        }

        /**
         * Call it after setting all parameters
         *
         * @return instance of class Actors
         */
        public Act build() {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Act>> constraintViolations = validator.validate(act);

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
            return act;
        }


        public Builder addRole(ActorsRole roles) {
            act.getActorsRole().add(roles);
            return this;
        }
    }
}