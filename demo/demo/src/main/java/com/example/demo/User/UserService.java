package com.example.demo.User;

import com.example.demo.Spot.Spot;
import com.example.demo.Spot.SpotRepository;
import com.example.demo.Spot.SpotController;
import com.example.demo.Floor.FloorController;
import com.example.demo.Ticket.Ticket;
import com.example.demo.Ticket.TicketController;
import com.example.demo.Ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TicketController ticketController;
    private final SpotRepository spotRepository;
    private final SpotController spotController;
    private  final FloorController floorController;
    private final TicketRepository ticketRepository;
    @Autowired
    public UserService(UserRepository userRepository, TicketController ticketController, SpotRepository spotRepository, SpotController spotController, FloorController floorController, TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.ticketController = ticketController;
        this.spotRepository = spotRepository;
        this.spotController = spotController;
        this.floorController = floorController;
        this.ticketRepository = ticketRepository;
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String id){
        Long user_id = Long.parseLong(id);
        return userRepository.findById(user_id).orElse(null);
    }

    public User updeateTick(String id ){
        Long user_id = Long.parseLong(id);


        return userRepository.findById(user_id).orElse(null);
    }

    public void createUser(User user){
        Long spotId = user.getSpot().getId();
        Spot spot = spotRepository.getById(spotId);
        spotController.updateTaking(spot);
        floorController.updateFullPark(spot.getFloor(),1);
        if(spot != null){
            user.setSpot(spot);
            userRepository.save(user);
        }
        ticketController.addTicket(user);


    }

    public void deleteUser(String id){
        Long user_id = Long.parseLong(id);
        userRepository.deleteById(user_id);

    }



}
