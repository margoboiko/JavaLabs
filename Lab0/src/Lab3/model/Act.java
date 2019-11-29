package Lab3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Act {

    public static final Integer MAX_NAME_LENGTH = 30;
    private String name;
    private String genre;
    private List<ActorsRole> roles = null;

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
    public class Builder {

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
            return act;
        }


        public Builder addRole(ActorsRole roles) {
            if (roles == null)
                Act.this.roles = new ArrayList<>();
            else
                Act.this.roles.add(roles);
            return this;
        }
    }
}