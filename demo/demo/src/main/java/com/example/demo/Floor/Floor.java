package com.example.demo.Floor;

import javax.persistence.*;

@Entity
@Table(name = "floor")
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private  int floor_park;
    private  int full_park;

    public Floor() {
    }

    public Floor(Long id, String name, int floor_park, int full_park) {
        this.id = id;
        this.name = name;
        this. floor_park = floor_park;
        this.full_park = full_park;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setFloor_park(int floor_park) {
        this.floor_park = floor_park;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor_park() {
        return floor_park;
    }


    public int getFull_park() {
        return full_park;
    }

    public void setFull_park(int full_park) {
        full_park = full_park;
    }
}


