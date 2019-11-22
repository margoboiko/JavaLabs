package Lab3.model;

import Lab3.model.Actors;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ActorsRole {
   private List<Actors> actor;
   private String role;

    public ActorsRole(List<Actors> actor, String role) {
        this.actor = actor;
        this.role = role;
    }

    public List<Actors> getActor() {
        return actor;
    }

    public void setActor(List<Actors> actor) {
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

    /**
     * inner class builder which implements
     * pattern "Builder"
     */
    public class Builder {

        public Builder() {
            // private constructor
        }

        public ActorsRole.Builder setActor(Actors actor) {
            if (actor == null)
                ActorsRole.this.actor = null;
            else
            ActorsRole.this.actor.add(actor);
            return this;
        }

        /**
         *
         * @param role lenght must be less than 20
         * @return instance of this builder
         */
        public ActorsRole.Builder setRole(String role) {
            if (role.length() > 20)
                throw new RuntimeException("Please rewrite!");
            else
            ActorsRole.this.role = role;
            return this;
        }

        /**
         * Call it after setting all parameters
         * @return instance of class Actors
         */
        public ActorsRole build()
        {
            return ActorsRole.this;
        }

    }
}

