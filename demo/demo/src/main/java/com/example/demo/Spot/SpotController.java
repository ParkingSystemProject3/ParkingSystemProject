package com.example.demo.Spot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path="spot")
public class SpotController {
    private final SpotService SpotService;
    @Autowired
    public SpotController(com.example.demo.Spot.SpotService spotService) {
        this.SpotService = spotService;
    }

    @GetMapping
    public List<Spot> getSpots(){
        return SpotService.getSpots();

    }

    @GetMapping("/{id}")
    public Spot getSpot(@PathVariable String id){
        return SpotService.getSpot(id);

    }

    @PostMapping
    public Spot createSpot(@RequestBody Form form){
        System.out.println(form.getFloor_id());
        return SpotService.createSpot(form.getSpot(),form.getUser_id(),form.getFloor_id());
    }
}

class Form{
    private Spot spot;
    private Long user_id;
    private  Long floor_id;

    public Form(Spot spot, Long user_id, Long floor_id) {
        this.spot = spot;
        this.user_id = user_id;
        this.floor_id = floor_id;
    }

    public Spot getSpot() {
        return spot;
    }

    public Long getUser_id() {
        return user_id;
    }

    public Long getFloor_id() {
        return floor_id;
    }
}
