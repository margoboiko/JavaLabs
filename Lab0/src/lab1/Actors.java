package lab1;


import java.time.LocalDate;
import java.util.Objects;

public class Actors {
    private LocalDate MAXYEAR =  LocalDate.of(1960, 1, 1);
    public static final Double MINSALARY = 3000d;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Double salary;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        if (birthday.isBefore(MAXYEAR))
            throw new RuntimeException("Please rewrite!");
        this.birthday = birthday;
    }

    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        if (salary < MINSALARY)
            throw new RuntimeException("Please rewrite!");
        this.salary = salary;
    }



    @Override
    public String toString() {
        return "Actors{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actors actors = (Actors) o;
        return Objects.equals(firstName, actors.firstName) &&
                Objects.equals(lastName, actors.lastName) &&
                Objects.equals(birthday, actors.birthday) &&
                Objects.equals(salary, actors.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthday, salary);
    }

    public class Builder {

        public Builder() {
            // private constructor
        }

        public Actors.Builder setFirstName(String firstName) {
            Actors.this.firstName = firstName;
            return this;
        }

        public Actors.Builder setLastName(String lasttName) {
            Actors.this.lastName = lastName;
            return this;
        }

        public Actors.Builder setBirthday(LocalDate birthday) {
            if (birthday.isBefore(MAXYEAR))
                throw new RuntimeException("Please rewrite!");
            else
            Actors.this.birthday = birthday;
            return this;
        }

        public Actors.Builder setSalary(Double salary) {
            if (salary < MINSALARY)
                throw new RuntimeException("Please rewrite!");
            else
                Actors.this.salary = salary;
            return this;
        }

        public Actors build() {
            return Actors.this;
        }

    }
}