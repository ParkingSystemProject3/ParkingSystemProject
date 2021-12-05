package com.example.demo.Ticket;


import com.example.demo.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "ticket")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @GetMapping
    public List<Ticket> getTickets(){
        return ticketService.getTickets();
    }

    @PostMapping
    public Ticket addTicket(User user){
        return ticketService.addTicket(user);
    }

    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable String id){
        return ticketService.getTicket(id);

    }
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable String id){
        ticketService.deleteTicket(id);

    }

    @PutMapping("/{plate_num}")
    public void updateTodo(@PathVariable String plate_num){
        ticketService.updateTicket(plate_num);
    }
}
