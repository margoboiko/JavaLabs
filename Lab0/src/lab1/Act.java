package lab1;

import java.util.Objects;

public class Act {
    public static final Integer MAXNAMELENGTH = 30;
   private String name;
   private String genre;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name.length() > MAXNAMELENGTH)
            throw new RuntimeException("Please rewrite!");
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Act{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Act act = (Act) o;
        return Objects.equals(name, act.name) &&
                Objects.equals(genre, act.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre);
    }


    public static class Builder {

        Act act;

        public Builder() {
            act=new Act();
        }

        public Builder setName(String name) {
            if (name.length() > MAXNAMELENGTH)
                throw new RuntimeException("Please rewrite!");
            else
            act.name = name;
            return this;
        }

        public Builder setGenre(String genre) {
            act.genre = genre;
            return this;
        }

        public Act build() {
            return act;
        }
    }
}
