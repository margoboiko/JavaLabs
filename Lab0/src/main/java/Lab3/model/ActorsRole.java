package Lab3.model;

import Lab3.model.Actors;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ActorsRole implements Comparable<ActorsRole> {
   private Actors actor;
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
            if (actor == null)
                ActorsRole.this.actor = null;
            else
            ActorsRole.this.actor = actor;
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

