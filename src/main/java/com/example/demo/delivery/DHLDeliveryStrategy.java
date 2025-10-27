package com.example.demo.delivery;

public class DHLDeliveryStrategy implements Delivery {
    @Override
    public double delivery(double orderPrice) {
        return 50 + 0.01 * orderPrice;
    }
}
