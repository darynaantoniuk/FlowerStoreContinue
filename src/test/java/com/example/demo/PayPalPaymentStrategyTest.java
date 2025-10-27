package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.payment.PayPalPaymentStrategy;
import com.example.demo.payment.Payment;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PayPalPaymentStrategyTest {

    @Test
    void testPayWithValidAmount() {
        PayPalPaymentStrategy strategy = new PayPalPaymentStrategy("user@example.com");
        boolean result = strategy.pay(100.0);
        assertTrue(result);
    }

    @Test
    void testPayWithZeroAmount() {
        PayPalPaymentStrategy strategy = new PayPalPaymentStrategy("user@example.com");
        boolean result = strategy.pay(0.0);
        assertTrue(result);
    }

    @Test
    void testPayWithLargeAmount() {
        PayPalPaymentStrategy strategy = new PayPalPaymentStrategy("test@paypal.com");
        boolean result = strategy.pay(9999.99);
        assertTrue(result);
    }

    @Test
    void testPayWithDecimalAmount() {
        PayPalPaymentStrategy strategy = new PayPalPaymentStrategy("user@test.com");
        boolean result = strategy.pay(49.99);
        assertTrue(result);
    }

    @Test
    void testPayPrintsCorrectMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        PayPalPaymentStrategy strategy = new PayPalPaymentStrategy("test@email.com");
        strategy.pay(50.0);

        String output = outContent.toString();
        assertTrue(output.contains("Charging PayPal account test@email.com"));
        assertTrue(output.contains("amount = $50.0"));

        System.setOut(System.out);
    }

    @Test
    void testNameReturnsPaypal() {
        PayPalPaymentStrategy strategy = new PayPalPaymentStrategy("user@example.com");
        assertEquals("paypal", strategy.name());
    }

    @Test
    void testImplementsPaymentInterface() {
        PayPalPaymentStrategy strategy = new PayPalPaymentStrategy("user@example.com");
        assertTrue(strategy instanceof Payment);
    }

    @Test
    void testWithDifferentEmailFormats() {
        PayPalPaymentStrategy strategy1 = new PayPalPaymentStrategy("simple@test.com");
        PayPalPaymentStrategy strategy2 = new PayPalPaymentStrategy("complex.name+tag@subdomain.example.co.uk");
        
        assertTrue(strategy1.pay(10.0));
        assertTrue(strategy2.pay(20.0));
        assertEquals("paypal", strategy1.name());
        assertEquals("paypal", strategy2.name());
    }
}