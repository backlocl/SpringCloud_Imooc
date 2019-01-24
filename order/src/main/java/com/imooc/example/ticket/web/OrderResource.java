package com.imooc.example.ticket.web;
import com.imooc.example.ticket.dao.OrderRepository;
import com.imooc.example.ticket.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mavlarn on 2018/1/20.
 */
@RestController
@RequestMapping("/api/order")
public class OrderResource {

    @PostConstruct
    public void init() {
        Order order = new Order();
        order.setAmount(100);
        order.setTitle("MyOrder");
        order.setDetail("Bought a imooc course");
        orderRepository.save(order);
    }

    @Autowired
    private OrderRepository orderRepository;

    /*@PostMapping("")
    public OrderDTO create(@RequestBody OrderDTO dto) {
        Order ticket = new Order();
        ticket.setAmount(dto.getAmount());
        ticket.setTitle(dto.getTitle());
        ticket.setDetail(dto.getDetail());
        ticket = orderRepository.save(ticket);
        dto.setId(ticket.getId());
        return dto;
    }

    @GetMapping("/{id}")
    public OrderDTO getMyOrder(@PathVariable Long id) {
        Order ticket = orderRepository.findOne(id);
        OrderDTO dto = new OrderDTO();
        dto.setId(ticket.getId());
        dto.setAmount(ticket.getAmount());
        dto.setTitle(ticket.getTitle());
        dto.setDetail(ticket.getDetail());
        return dto;
    }*/

    @GetMapping("")
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Map getId(@PathVariable Long id){
        System.out.println("id:"+id);
        Order myOrder = orderRepository.findOneByTitle("MyOrder");
        Map map = new HashMap();
        map.put("myOrder",myOrder);
        return map;
    }

}
