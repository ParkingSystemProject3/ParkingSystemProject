package com.example.demo.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
    @Query(value ="select ticket.* from ticket  left join users on ticket.user_id = users.id where users.plat_number =?1",nativeQuery = true)
    public Ticket findTicketByPlatNumber(String platNum);
}
