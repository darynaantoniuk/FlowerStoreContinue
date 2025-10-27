package com.example.demo.controller;

import com.example.demo.delivery.DHLDeliveryStrategy;
import com.example.demo.delivery.Delivery;
import com.example.demo.delivery.PostalDeliveryStrategy;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @GetMapping
    public List<String> getAllDeliveries() {
        return List.of("postal", "dhl");
    }

    @GetMapping("/{type}")
    public Map<String, Object> getDeliveryCost(@PathVariable String type,
                                               @RequestParam double price) {
        Delivery delivery;
        switch (type.toLowerCase()) {
            case "dhl":
                delivery = new DHLDeliveryStrategy();
                break;
            case "postal":
                delivery = new PostalDeliveryStrategy();
                break;
            default:
                return Map.of("error", "Unknown delivery type: " + type);
        }

        double cost = delivery.delivery(price);
        return Map.of(
                "deliveryType", type,
                "orderPrice", price,
                "deliveryCost", cost
        );
    }
}
