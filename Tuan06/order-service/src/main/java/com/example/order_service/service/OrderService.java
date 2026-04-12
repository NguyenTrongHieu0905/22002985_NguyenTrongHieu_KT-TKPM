package com.example.order_service.service;

import com.example.order_service.model.Food;
import com.example.order_service.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderService {

    private final List<Order> orders = new ArrayList<>();
    private Long idCounter = 1L;

    private final RestTemplate restTemplate;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Order create(Order order) {

        // 🔥 1. Validate user
        String userUrl = "http://user.local:8081/users";
        Object users = restTemplate.getForObject(userUrl, Object.class);

        if (users == null) {
            throw new RuntimeException("User service lỗi");
        }

        // 🔥 2. Lấy danh sách food
        String foodUrl = "http://food.local:8082/foods";
        Food[] foodList = restTemplate.getForObject(foodUrl, Food[].class);

        // 🔥 3. Set order
        order.setId(idCounter++);
        order.setStatus("CREATED");

        if (order.getItems() == null) {
            order.setItems(new HashMap<>());
        }

        orders.add(order);

        return order;
    }

    public List<Order> getAll() {
        return orders;
    }

    public Order addItem(Long orderId, Long foodId) {
        for (Order o : orders) {
            if (o.getId().equals(orderId)) {
                o.getItems().put(
                        foodId,
                        o.getItems().getOrDefault(foodId, 0) + 1
                );
                return o;
            }
        }
        return null;
    }

    public Order removeItem(Long orderId, Long foodId) {
        for (Order o : orders) {
            if (o.getId().equals(orderId)) {
                o.getItems().remove(foodId);
                return o;
            }
        }
        return null;
    }

    public Order markPaid(Long id) {
        for (Order o : orders) {
            if (o.getId().equals(id)) {
                o.setStatus("PAID");
                return o;
            }
        }
        return null;
    }
}