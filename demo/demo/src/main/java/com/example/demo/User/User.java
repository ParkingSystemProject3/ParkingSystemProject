package com.example.demo.User;

import com.example.demo.Spot.Spot;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fName;
    private String lName;
    private String platNumber;
    private Long phone ;

    @ManyToOne (fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name ="spot_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Spot spot ;


    public User() {
    }

    public User(Long id, String fName, String lName, String platNumber, Long phone, Spot spot) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.platNumber = platNumber;
        this.phone = phone;
        this.spot = spot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPlatNumber() {
        return platNumber;
    }

    public void setPlatNumber(String platNumber) {
        this.platNumber = platNumber;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }
}
