package Lab5_6.model;



import javax.validation.constraints.NotNull;
import java.sql.Connection;
import java.util.Objects;

public class ActorsRole implements Comparable<ActorsRole> {
    @NotNull(message = " field can`t be null")
    private Integer id;
   private Actors actor;
   private String role;

    public ActorsRole(Connection connection) {
    }

    public Actors getActor() {
        return actor;
    }
    //public void setActor(Actors actor) { this.actor = actor; }

    public String getRole() {
        return role;
    }
   // public void setRole(int role) { this.role = role; }

    public Integer getId() {
        return id;
    }
//    public void setId(Integer id) {
//        this.id = id;
//    }

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

//    public ActorsRole resultSetToObj(ResultSet resultSet) {
//    }

    /**
     *
     * inner class builder which implements
     * pattern "Builder"
     */
    public class Builder {

        public Builder() {
        }

        public Builder setId(Integer id) {
            ActorsRole.this.id = id;
            return this;
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
        public ActorsRole build()
        {
            return ActorsRole.this;
        }

    }
}

