package com.example.demo.Ticket;

import com.example.demo.Floor.Floor;
import com.example.demo.Spot.Spot;
import com.example.demo.User.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Time;
import java.time.LocalTime;
import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalTime startTime;
    private LocalTime endTime;
    private double price;
    @ManyToOne (fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name ="user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user ;
    @ManyToOne (fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name ="spot_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Spot spot ;

    public Ticket() {
    }

    public Ticket(long id, LocalTime startTime, LocalTime endTime, double price, User user, Spot spot) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.user = user;
        this.spot = spot;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }
}
