package com.example.payment_service.controller;

import com.example.payment_service.model.Payment;
import com.example.payment_service.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public void pay(@RequestBody Payment payment) {
        paymentService.process(payment);
    }

    @GetMapping
    public List<Payment> history() {
        return paymentService.getHistory();
    }
}