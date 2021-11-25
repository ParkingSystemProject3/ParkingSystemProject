package com.example.demo.Spot;

import com.example.demo.Floor.Floor;
import com.example.demo.User.User;

import javax.persistence.*;

@Entity
@Table(name = "spot")
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String slot_type;
    private boolean taking ;

    @ManyToOne (fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name ="floor_id")
    private Floor floor ;
    @ManyToOne (fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name ="user_id")
    private User user ;

    public Spot() {

    }

    public Spot(Long id, String slot_type, boolean taking, Floor floor, User user) {
        this.id = id;
        this.slot_type = slot_type;
        this.taking = taking;
        this.floor = floor;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlot_type() {
        return slot_type;
    }

    public void setSlot_type(String slot_type) {
        this.slot_type = slot_type;
    }

    public boolean isTaking() {
        return taking;
    }

    public void setTaking(boolean taking) {
        this.taking = taking;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
