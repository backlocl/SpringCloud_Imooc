package com.imooc.example.ticket.dao;

import com.imooc.example.ticket.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mavlarn on 2018/1/20.
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findOneByOwner(Long owner);
}
