package com.example.demo.Spot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(path="spot")
public class SpotController {
    private final SpotService SpotService;
    @Autowired
    public SpotController(com.example.demo.Spot.SpotService spotService) {
        this.SpotService = spotService;
    }

    @PostMapping
    public Spot createSpot(@RequestBody Spot spot){
        return SpotService.createSpot(spot);
    }

    @GetMapping("/{id}")
    public Spot getAvailableSpot(@PathVariable String id){
        return SpotService.getAvailableSpot(id);
    }

    @PutMapping
    public void updateTaking(Spot spot){
        SpotService.updateTaking(spot);
    }
}