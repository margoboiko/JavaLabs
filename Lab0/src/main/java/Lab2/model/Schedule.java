package Lab2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import Lab2.service.LocalDateDeserializer;
import Lab2.service.LocalDateSerializer;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Schedule implements Comparable<Schedule> {
    public static final Double MAXPRICE = 200.00;
   private Act act;
    @JsonFormat(pattern = "yyyyMMdd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
   private LocalDate date;
   private LocalTime time;
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
        return 0;
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
            if (price > MAXPRICE)
                throw new RuntimeException("Please rewrite!");
            else
            Schedule.this.price = price;
            return this;
        }

        /**
         * Call it after setting all parameters
         * @return instance of class Schedule
         */
        public Schedule build() {
            return Schedule.this;
        }

    }
}