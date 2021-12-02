package com.example.demo.Floor;

import com.example.demo.Spot.Spot;
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
        System.out.println(" floorRepository"+floorRepository.findById(floor_id).orElse(null) );
        return floorRepository.findById(floor_id).orElse(null);
    }
    public  Floor createFloor(Floor floor){
        return floorRepository.save(floor);

    }

    public void deleteFloor(String id){
        Long floor_id = Long.parseLong(id);
        floorRepository.deleteById(floor_id);

    }

    public void updateFullPark(Floor floor){
    floor.setFull_park(floor.getFull_park()+1);
        floorRepository.save(floor);
    }
}
