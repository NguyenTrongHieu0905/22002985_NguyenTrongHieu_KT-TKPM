package com.example.order_service.model;

import java.util.Map;

public class Order {

    private Long id;
    private Long userId;

    // 🔥 key = foodId, value = quantity
    private Map<Long, Integer> items;

    private String status;

    public Order() {}

    public Order(Long id, Long userId, Map<Long, Integer> items, String status) {
        this.id = id;
        this.userId = userId;
        this.items = items;
        this.status = status;
    }

    // ===== GETTER & SETTER =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Map<Long, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Long, Integer> items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}