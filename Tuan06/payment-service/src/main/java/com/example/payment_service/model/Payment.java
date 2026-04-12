package com.example.payment_service.model;

public class Payment {

    private Long orderId;
    private String method;
    private String status;

    public Payment() {}

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}