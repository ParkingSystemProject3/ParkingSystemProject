package com.example.demo.Ticket;

import java.sql.Time;
import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Time startTime;
    private Time endTime;
    private double price;

    public Ticket() {
    }

    public Ticket(long id, Time startTime, Time endTime, double price) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", startDate=" + startTime +
                ", endDate=" + endTime +
                ", price=" + price +
                '}';
    }
}
