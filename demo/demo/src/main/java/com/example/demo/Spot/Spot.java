package com.example.demo.Spot;

import javax.persistence.*;

@Entity
@Table(name = "spot")
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long Floor_id;
    private String slot_type;
    private boolean taking ;

    public Spot() {

    }

    public Spot(Long id, Long floor_id, String slot_type, boolean taking) {
        this.id = id;
        Floor_id = floor_id;
        this.slot_type = slot_type;
        this.taking = taking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFloor_id() {
        return Floor_id;
    }

    public void setFloor_id(Long floor_id) {
        Floor_id = floor_id;
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
}
