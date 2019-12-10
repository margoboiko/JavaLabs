package Lab3.service;

import Lab3.model.Act;
import Lab3.model.Actors;
import Lab3.model.ActorsRole;

import java.util.*;
import java.util.stream.Collectors;

public class ActService {

    private Act act;

    public ActService() {
    }

    public ActService(Act act) {
        this.act = act;
    }

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    /**
     *
     * @return role sorting
     */
    public List<ActorsRole> sortActByRole() {
        return act.getActorsRole().stream()
                .sorted(Comparator.comparing(ActorsRole::getRole))
                .collect(Collectors.toList());
    }

    /**
     * @return average salary return
     */
    public double getAvgSalary() {
        return act.getActorsRole().stream()
                .map(actorsRole -> actorsRole.getActor().getSalary())
                .reduce(0d, Double::sum)/act.getActorsRole().size();
    }

    /**
     *
     * @param role
     * @return conclusion of actors playing this role
     */
    public List<Actors> getListActors(String role) {
        return act.getActorsRole().stream()
                .filter(role1-> role1.getRole().equals(role))
                .map(ActorsRole::getActor)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "ActService{" +
                "act=" + act +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActService that = (ActService) o;
        return Objects.equals(act, that.act);
    }

    @Override
    public int hashCode() {
        return Objects.hash(act);
    }
}