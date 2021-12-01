package com.example.demo.Spot;

import com.example.demo.Floor.Floor;
import com.example.demo.Floor.FloorRepository;
import com.example.demo.User.User;
import com.example.demo.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotService {
    private final SpotRepository spotRepository ;
    private  final FloorRepository floorRepository;

    @Autowired
    public SpotService(SpotRepository spotRepository,  FloorRepository floorRepository) {
        this.spotRepository = spotRepository;
        this.floorRepository = floorRepository;
    }

    public List<Spot> getSpots(){
        return spotRepository.findAll();
    }

    public Spot getSpot(String id){
        Long spot_id = Long.parseLong(id);
        return spotRepository.findById(spot_id).orElse(null);
    }
    public  Spot createSpot(Spot spot){

        Long floorId = spot.getFloor().getId();
        Floor floor = floorRepository.getById(floorId);

        if(floor != null ){
            spot.setFloor(floor);
            return spotRepository.save(spot);
        }
        return null;

    }
}
