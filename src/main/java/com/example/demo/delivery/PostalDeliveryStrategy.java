package com.example.demo.delivery;

public class PostalDeliveryStrategy implements Delivery {
    @Override
    public double delivery(double orderPrice) {
        System.out.println("Postal delivery");
        if (orderPrice > 1000) {
            return 0;
        }
        return 100;
    }
}
