package com.example.demo.Ticket;

import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    @Autowired

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getTickets(){

        return ticketRepository.findAll();
    }

    public Ticket addTicket(Ticket ticket){
        return ticketRepository.save(ticket);
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
            ticket.setStartDate(data.getStartDate());
            ticket.setEndDate(data.getEndDate());
            ticket.setPrice(data.getPrice());
            ticket.setActive(data.isActive());
            ticketRepository.save(ticket);
        }

    }
}
