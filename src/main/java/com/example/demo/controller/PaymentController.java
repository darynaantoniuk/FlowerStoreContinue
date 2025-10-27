package com.example.demo.controller;

import com.example.demo.payment.CreditCardPaymentStrategy;
import com.example.demo.payment.PayPalPaymentStrategy;
import com.example.demo.payment.Payment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @GetMapping
    public List<String> getAllPayments() {
        return List.of("creditcard", "paypal");
    }

    @GetMapping("/{type}")
    public Map<String, Object> simulatePayment(@PathVariable String type,
                                               @RequestParam double amount) {
        Payment payment;
        switch (type.toLowerCase()) {
            case "creditcard":
                payment = new CreditCardPaymentStrategy("4111111111111111");
                break;
            case "paypal":
                payment = new PayPalPaymentStrategy("user@example.com");
                break;
            default:
                return Map.of("error", "Unknown payment type: " + type);
        }

        boolean success = payment.pay(amount);
        return Map.of(
                "paymentType", payment.name(),
                "amount", amount,
                "status", success ? "success" : "failed"
        );
    }
}
