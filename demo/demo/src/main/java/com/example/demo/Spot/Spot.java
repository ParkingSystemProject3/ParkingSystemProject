package com.example.demo.Spot;

import com.example.demo.Floor.Floor;
import com.example.demo.User.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "spot")
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String slot_type;
    private boolean taking ;

    @ManyToOne (fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name ="floor_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Floor floor ;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spot")
    private List<User> users = new ArrayList<>();

    public Spot() {

    }


    public Spot(Long id, String slot_type, boolean taking, Floor floor, List<User> users) {
        this.id = id;
        this.slot_type = slot_type;
        this.taking = taking;
        this.floor = floor;
        this.users = users;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
