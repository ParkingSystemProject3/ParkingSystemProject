package com.example.demo.Ticket;

import com.example.demo.Spot.Spot;
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
    public Ticket addTicket(@RequestBody User user , Spot spot){
        return ticketService.addTicket(user , spot);
    }

    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable String id){
        return ticketService.getTicket(id);

    }
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable String id){
        ticketService.deleteTicket(id);

    }

//    @PutMapping("/{id}")
//    public void updateTodo(@PathVariable String id, @RequestBody Ticket data){
//        ticketService.updateTicket(id, data);
//    }
}
