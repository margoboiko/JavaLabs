package lab1;

import java.time.LocalDate;
import java.util.Objects;

public class Actors {    public static final Integer MAXFIRSTNAMELENGTH = 20;
    public static final Double MAXSALARY = 1000.00;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Double salary;

    public Actors() {
    }

    public void setFirst_name(String firstName) {
        if (firstName.length() > MAXFIRSTNAMELENGTH)
            throw new RuntimeException("Wrong input!");
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Double getSalary() {
        return salary;
    }

    public void setLastName(String lastName) {
        if (lastName.length() > MAXFIRSTNAMELENGTH)
            throw new RuntimeException("Wrong input!");
        this.lastName = lastName;
    }

    public void setSalary(Double salary) {
        if (salary < MAXSALARY)
            throw new RuntimeException("Wrong input!");
        this.salary = salary;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actors actors = (Actors) o;
        return Objects.equals(firstName, actors.firstName) &&
                Objects.equals(lastName, actors.lastName) &&
                Objects.equals(birthday, actors.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthday);
    }

}
