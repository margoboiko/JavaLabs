package Lab3.service;

import Lab3.model.Actors;
import Lab3.model.ActorsRole;

import java.util.*;

public class ActorsRoleService {

    private ActorsRole actorsRole;

    public ActorsRoleService() {
    }

    public ActorsRoleService(ActorsRole actorsRole) {
        this.actorsRole = actorsRole;
    }

    public ActorsRole getActorsRole() {
        return actorsRole;
    }

    public void setActorsRole(ActorsRole actorsRole) {
        this.actorsRole = actorsRole;
    }

    /**
     * @return search actor in actors role
     */
    public Optional<Actors> getListActors(String name) {
        return actorsRole.getActor().stream()
                .filter(actor-> actor.getFirstName().equals(name))
                .findFirst();

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorsRoleService that = (ActorsRoleService) o;
        return Objects.equals(actorsRole, that.actorsRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorsRole);
    }

    @Override
    public String toString() {
        return "ActorsRoleService{" +
                "actorsRole=" + actorsRole +
                '}';
    }
}