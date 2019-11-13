package lab1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Schedule {
    public static final Double MAXPRICE = 200.00;
   private Act act;
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

        public Builder setPrice(Double price) {
            if (price > MAXPRICE)
                throw new RuntimeException("Please rewrite!");
            else
            Schedule.this.price = price;
            return this;
        }
        public Schedule build() {
            return Schedule.this;
        }

    }
}