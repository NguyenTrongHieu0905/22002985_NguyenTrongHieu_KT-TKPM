package com.example.payment_service.service;

import com.example.payment_service.model.Payment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    private final RestTemplate restTemplate;
    private final List<Payment> history = new ArrayList<>();

    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void process(Payment payment) {

        // gọi order service
        String url = "http://order.local:8083/orders/" + payment.getOrderId() + "/paid";
        restTemplate.postForObject(url, null, Object.class);

        payment.setStatus("SUCCESS");

        // lưu lịch sử
        history.add(payment);

        // notification
        System.out.println("🔥 Thanh toán đơn #" + payment.getOrderId() + " thành công");
    }

    public List<Payment> getHistory() {
        return history;
    }
}