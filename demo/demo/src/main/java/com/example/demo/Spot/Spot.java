package com.example.demo.Spot;

import javax.persistence.*;

@Entity
@Table(name = "spot")
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long Floor_id;
    private boolean slot_type;

    public Spot(Long id, Long floor_id, boolean slot_type) {
        this.id = id;
        Floor_id = floor_id;
        this.slot_type = slot_type;
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

    public boolean isSlot_type() {
        return slot_type;
    }

    public void setSlot_type(boolean slot_type) {
        this.slot_type = slot_type;
    }
}
