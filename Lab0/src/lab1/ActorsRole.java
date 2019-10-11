package lab1;

import java.util.Objects;

public class ActorsRole {
    Actors actor;
    String role;

    public Actors getActor() {
        return actor;
    }

    public void setActor(Actors actor) {
        this.actor = actor;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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
}
