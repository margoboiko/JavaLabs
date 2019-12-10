package Lab5_6.model;

import Lab2.model.Act;
import Lab2.service.LocalDateDeserializer;
import Lab2.service.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Schedule implements Comparable<Schedule> {
  //  public static final Double MAXPRICE = 200.00;
  @NotNull(message = " field can`t be null")
    private Integer id;
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
    public void setPrice(Double price) { this.price = price; }

    @NotNull
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

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

        public Builder setId(Integer act) {
            Schedule.this.id = id;
            return this;
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