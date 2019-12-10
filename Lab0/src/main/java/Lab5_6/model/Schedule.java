package Lab5_6.model;

import Lab2.service.LocalDateDeserializer;
import Lab2.service.LocalDateSerializer;
import Lab4.model.Act;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;

public class Schedule implements Comparable<Schedule> {
    public static final Double MAXPRICE = 200.00;
   private Act act;

   @JsonFormat(pattern = "yyyyMMdd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
   @Future
   private LocalDate date;
   private LocalTime time;
   @Max(200)
   private Double price;

   public Schedule() {

   }

    public Schedule(Act act, LocalDate date, LocalTime time, Double price) {
        this.act = act;
        this.date = date;
        this.time = time;
        this.price = price;
    }

    public Act getAct() {
        return act;
    }
    public void setAct(Act act) {
        this.act = act;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Double getPrice() { return price; }
    public void setPrice(Double price) {
        if (price > MAXPRICE)
            throw new RuntimeException("Please rewrite!");
        this.price = price;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "act='" + act + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(act, schedule.act) &&
                Objects.equals(date, schedule.date) &&
                Objects.equals(time, schedule.time) &&
                Objects.equals(price, schedule.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(act, date, time, price);
    }

    @Override
    public int compareTo(Schedule schedule) {
        return Double.compare(this.price, schedule.price);
    }

    /**
     * inner class builder which implements
     * pattern "Builder"
     */
    public class Builder {

        public Builder() {
            // private constructor
        }

        public Builder setAct(Act act) {
            Schedule.this.act = act;
            return this;
        }

        public Builder setDate(LocalDate date) {
            Schedule.this.date = date;
            return this;
        }

        public Builder setTime(LocalTime time) {
            Schedule.this.time = time;
            return this;
        }

        /**
         * Sets price for one ticket
         * @param price Double must be less than MAXPRICE
         * @return instance of this builder
         */
        public Builder setPrice(Double price) {
            return this;
        }

        /**
         * Call it after setting all parameters
         * @return instance of class Schedule
         */
        public Schedule build() {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Schedule>> constraintViolations = validator.validate(Schedule.this);

            if(!constraintViolations.isEmpty()) {
                StringBuilder str = new StringBuilder();
                constraintViolations .forEach(constraint -> {
                    str.append(constraint.getPropertyPath())
                            .append(" : ")
                            .append(constraint.getMessage())
                            .append("\n");
                });
                throw new RuntimeException(str.toString());
            }
            return Schedule.this;
        }

    }
}