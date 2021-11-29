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
    private  final UserRepository userRepository ;
    private  final FloorRepository floorRepository;

    @Autowired
    public SpotService(SpotRepository spotRepository, UserRepository userRepository, FloorRepository floorRepository) {
        this.spotRepository = spotRepository;
        this.userRepository = userRepository;
        this.floorRepository = floorRepository;
    }

    public List<Spot> getSpots(){
        return spotRepository.findAll();
    }

    public Spot getSpot(String id){
        Long spot_id = Long.parseLong(id);
        return spotRepository.findById(spot_id).orElse(null);
    }
    public  Spot createSpot(Spot spot ,Long user_id ,Long floor_id){
        System.out.println(user_id);
        System.out.println(floor_id);
        User user =userRepository.findById(user_id).orElse(null);
        System.out.println(user);
        spot.setUser(user);
        Floor floor =floorRepository.findById(floor_id).orElse(null);
        spot.setFloor(floor);
        System.out.println(floor);
        return spotRepository.save(spot);

    }
}
