package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.delivery.Delivery;
import com.example.demo.delivery.PostalDeliveryStrategy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PostalDeliveryStrategyTest {

    @Test
    void testDeliveryWithOrderPriceBelowThreshold() {
        PostalDeliveryStrategy strategy = new PostalDeliveryStrategy();
        double result = strategy.delivery(500);
        assertEquals(100.0, result, 0.01);
    }

    @Test
    void testDeliveryWithOrderPriceAtThreshold() {
        PostalDeliveryStrategy strategy = new PostalDeliveryStrategy();
        double result = strategy.delivery(1000);
        assertEquals(100.0, result, 0.01);
    }

    @Test
    void testDeliveryWithOrderPriceAboveThreshold() {
        PostalDeliveryStrategy strategy = new PostalDeliveryStrategy();
        double result = strategy.delivery(1001);
        assertEquals(0.0, result, 0.01);
    }

    @Test
    void testFreeDeliveryForLargeOrders() {
        PostalDeliveryStrategy strategy = new PostalDeliveryStrategy();
        double result = strategy.delivery(5000);
        assertEquals(0.0, result, 0.01);
    }

    @Test
    void testDeliveryWithZeroOrderPrice() {
        PostalDeliveryStrategy strategy = new PostalDeliveryStrategy();
        double result = strategy.delivery(0);
        assertEquals(100.0, result, 0.01);
    }

    @Test
    void testDeliveryPrintsMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        PostalDeliveryStrategy strategy = new PostalDeliveryStrategy();
        strategy.delivery(100);

        String output = outContent.toString();
        assertTrue(output.contains("Postal delivery"));

        System.setOut(originalOut);
    }

    @Test
    void testDeliveryImplementsInterface() {
        PostalDeliveryStrategy strategy = new PostalDeliveryStrategy();
        assertTrue(strategy instanceof Delivery);
    }

    @Test
    void testDeliveryWithOrderPriceJustBelowThreshold() {
        PostalDeliveryStrategy strategy = new PostalDeliveryStrategy();
        double result = strategy.delivery(999.99);
        assertEquals(100.0, result, 0.01);
    }

    @Test
    void testDeliveryWithOrderPriceJustAboveThreshold() {
        PostalDeliveryStrategy strategy = new PostalDeliveryStrategy();
        double result = strategy.delivery(1000.01);
        assertEquals(0.0, result, 0.01);
    }
}
