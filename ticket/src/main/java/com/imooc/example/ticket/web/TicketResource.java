package com.imooc.example.ticket.web;
import com.imooc.example.ticket.dao.TicketRepository;
import com.imooc.example.ticket.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangtianzhi on 2019/1/13.
 */
@RestController
@RequestMapping("/api/ticket")
public class TicketResource {

    @PostConstruct
    public void init() {
        Ticket ticket = new Ticket();
        ticket.setName("myTicket");
        ticket.setTicketNum(100L);
        ticketRepository.save(ticket);
    }

    @Autowired
    private TicketRepository ticketRepository;

    /*@PostMapping("")
    public OrderDTO create(@RequestBody OrderDTO dto) {
        Ticket ticket = new Ticket();
        ticket.setAmount(dto.getAmount());
        ticket.setTitle(dto.getTitle());
        ticket.setDetail(dto.getDetail());
        ticket = ticketRepository.save(ticket);
        dto.setId(ticket.getId());
        return dto;
    }

    @GetMapping("/{id}")
    public OrderDTO getMyOrder(@PathVariable Long id) {
        Ticket ticket = ticketRepository.findOne(id);
        OrderDTO dto = new OrderDTO();
        dto.setId(ticket.getId());
        dto.setAmount(ticket.getAmount());
        dto.setTitle(ticket.getTitle());
        dto.setDetail(ticket.getDetail());
        return dto;
    }*/

    @GetMapping("")
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }


}
