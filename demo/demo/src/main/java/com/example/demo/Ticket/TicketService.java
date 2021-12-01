package com.example.demo.Ticket;

import com.example.demo.Spot.Spot;
import com.example.demo.Spot.SpotRepository;
import com.example.demo.User.User;
import com.example.demo.User.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final SpotRepository spotRepository;
    @Autowired

    public TicketService(TicketRepository ticketRepository, UserRepository userRepository, SpotRepository spotRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.spotRepository = spotRepository;
    }

    public List<Ticket> getTickets(){

        return ticketRepository.findAll();
    }

    public Ticket addTicket(Ticket ticket){
        long user_id=ticket.getUser().getId();
        User user=userRepository.getById(user_id);
        long spot_id=ticket.getSpot().getId();
        Spot spot=spotRepository.getById(spot_id);
        if(user !=null && spot!=null){
            ticket.setUser(user);
            ticket.setSpot(spot);
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

    public void updateTicket(String id, Ticket data){
        Long ticketId = Long.parseLong(id);
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);

        if (ticket != null){
            ticket.setStartTime(data.getStartTime());
            ticket.setEndTime(data.getEndTime());
            ticket.setPrice(data.getPrice());
            ticketRepository.save(ticket);
        }

    }
}
