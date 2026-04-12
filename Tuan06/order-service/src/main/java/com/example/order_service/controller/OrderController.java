package com.example.order_service.controller;

import com.example.order_service.model.Order;
import com.example.order_service.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @PostMapping("/{id}/add/{foodId}")
    public Order addItem(@PathVariable Long id, @PathVariable Long foodId) {
        return orderService.addItem(id, foodId);
    }

    @PostMapping("/{id}/decrease/{foodId}")
    public Order decreaseItem(@PathVariable Long id, @PathVariable Long foodId) {
        return orderService.removeItem(id, foodId);
    }

    @DeleteMapping("/{id}/remove/{foodId}")
    public Order removeItem(@PathVariable Long id, @PathVariable Long foodId) {
        return orderService.removeItem(id, foodId);
    }

    @PostMapping("/{id}/paid")
    public Order markPaid(@PathVariable Long id) {
        return orderService.markPaid(id);
    }
}