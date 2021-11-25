package com.example.demo.Floor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class FloorService {
    private final FloorRepository floorRepository ;

    @Autowired
    public FloorService(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    public List<Floor> getFloors(){
        return floorRepository.findAll();
    }

    public Floor getFloor(String id){
        Long floor_id = Long.parseLong(id);
        return floorRepository.findById(floor_id).orElse(null);
    }
    public  Floor createFloor(Floor floor){
        return floorRepository.save(floor);

    }
}
