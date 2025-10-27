package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.delivery.DHLDeliveryStrategy;
import com.example.demo.delivery.Delivery;

import static org.junit.jupiter.api.Assertions.*;

class DHLDeliveryStrategyTest {

    @Test
    void testDeliveryWithZeroOrderPrice() {
        DHLDeliveryStrategy strategy = new DHLDeliveryStrategy();
        double result = strategy.delivery(0);
        assertEquals(50.0, result, 0.01);
    }

    @Test
    void testDeliveryWithSmallOrderPrice() {
        DHLDeliveryStrategy strategy = new DHLDeliveryStrategy();
        double result = strategy.delivery(100);
        assertEquals(51.0, result, 0.01);
    }

    @Test
    void testDeliveryWithMediumOrderPrice() {
        DHLDeliveryStrategy strategy = new DHLDeliveryStrategy();
        double result = strategy.delivery(1000);
        assertEquals(60.0, result, 0.01);
    }

    @Test
    void testDeliveryWithLargeOrderPrice() {
        DHLDeliveryStrategy strategy = new DHLDeliveryStrategy();
        double result = strategy.delivery(5000);
        assertEquals(100.0, result, 0.01);
    }

    @Test
    void testDeliveryFormulaAccuracy() {
        DHLDeliveryStrategy strategy = new DHLDeliveryStrategy();
        double orderPrice = 2500;
        double expected = 50 + 0.01 * orderPrice;
        double result = strategy.delivery(orderPrice);
        assertEquals(expected, result, 0.01);
    }

    @Test
    void testDeliveryWithDecimalOrderPrice() {
        DHLDeliveryStrategy strategy = new DHLDeliveryStrategy();
        double result = strategy.delivery(123.45);
        assertEquals(51.2345, result, 0.0001);
    }

    @Test
    void testDeliveryImplementsInterface() {
        DHLDeliveryStrategy strategy = new DHLDeliveryStrategy();
        assertTrue(strategy instanceof Delivery);
    }
}