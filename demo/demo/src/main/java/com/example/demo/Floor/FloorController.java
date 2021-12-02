package com.example.demo.Floor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="floor")
public class FloorController {
    private final FloorService floorService;
    @Autowired
    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }
    @GetMapping
    public List<Floor> getFloors(){
        return floorService.getFloors();

    }

    @GetMapping("/{id}")
    public Floor getFloor(@PathVariable String id){
        return floorService.getFloor(id);

    }

    @PostMapping
    public Floor createFloor(@RequestBody Floor floor){
        return floorService.createFloor(floor);
    }

    @DeleteMapping("/{id}")
    public void deleteFloor(@PathVariable String id){
        floorService.deleteFloor(id);

    }
}
