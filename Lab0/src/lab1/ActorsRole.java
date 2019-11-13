package lab1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class ActorsRole {
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

    public class Builder {

        public Builder() {
            // private constructor
        }

        public ActorsRole.Builder setActor(Actors actor) {
            if (actor == null)
                ActorsRole.this.actor = null;
            else
            ActorsRole.this.actor = actor;
            return this;
        }

        public ActorsRole.Builder setRole(String role) {
            if (role.length() > 20)
                throw new RuntimeException("Please rewrite!");
            else
            ActorsRole.this.role = role;
            return this;
        }

        public ActorsRole build() {
            return ActorsRole.this;
        }

    }
}
