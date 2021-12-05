package com.example.demo.Ticket;

import com.example.demo.Floor.FloorController;
import com.example.demo.Spot.Spot;
import com.example.demo.Spot.SpotController;
import com.example.demo.Spot.SpotRepository;
import com.example.demo.User.User;
import com.example.demo.User.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final SpotRepository spotRepository;
    private final SpotController spotController;
    private FloorController floorController;

    @Autowired

    public TicketService(TicketRepository ticketRepository, UserRepository userRepository, SpotRepository spotRepository, SpotController spotController, FloorController floorController) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.spotRepository = spotRepository;
        this.spotController = spotController;
        this.floorController = floorController;
    }

    public List<Ticket> getTickets(){

        return ticketRepository.findAll();
    }


    public Ticket addTicket(String id){
        Ticket ticket =new Ticket();
        Long userId = Long.parseLong(id);
        System.out.println(userId);
        User user = userRepository.getById(userId);
        if(user != null){
            ticket.setUser(user);
            ticket.setStartTime(Instant.now());
            return ticketRepository.save(ticket);
        }
        return null;
    }

    public Ticket getTicket(String id) {

        Long ticketId = Long.parseLong(id);
        return ticketRepository.findById(ticketId).orElse(null);
    }

    public void deleteTicket(String id){
        Long ticketId = Long.parseLong(id);
        ticketRepository.deleteById(ticketId);

    }

    public void updateTicket(String plate_num){
        Ticket ticket = ticketRepository.findTicketByPlatNumber(plate_num);
        Instant end = Instant.now();
        ticket.setEndTime(end);
        Duration timeElapsed = Duration.between(ticket.getStartTime(), end);
        double time = timeElapsed.toMinutes()/60.0;
        int f = (int)Math.ceil(time);
        double price = f*10;
        ticket.setPrice(price);
        ticketRepository.save(ticket);
        Long user_id = ticket.getUser().getId();
        User user = userRepository.findById(user_id).orElse(null);
        Long spot_id = user.getSpot().getId();
        Spot spot = spotRepository.findById(spot_id).orElse(null);
        spotController.updateTaking(spot);
        floorController.updateFullPark(spot.getFloor(),2);
    }
}
