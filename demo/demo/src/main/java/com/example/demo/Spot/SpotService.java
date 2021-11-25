package com.example.demo.Spot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotService {
    private final SpotRepository spotRepository ;

    @Autowired
    public SpotService(com.example.demo.Spot.SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    public List<Spot> getSpots(){
        return spotRepository.findAll();
    }

    public Spot getSpot(String id){
        Long spot_id = Long.parseLong(id);
        return spotRepository.findById(spot_id).orElse(null);
    }
    public  Spot createSpot(Spot spot){
        return spotRepository.save(spot);

    }
}
