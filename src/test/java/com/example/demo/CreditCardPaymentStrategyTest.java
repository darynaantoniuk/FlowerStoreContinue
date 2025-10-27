package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.payment.CreditCardPaymentStrategy;
import com.example.demo.payment.Payment;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardPaymentStrategyTest {

    @Test
    void testPayWithValidAmount() {
        CreditCardPaymentStrategy strategy = new CreditCardPaymentStrategy("1234-5678-9012-3456");
        boolean result = strategy.pay(100.0);
        assertTrue(result);
    }

    @Test
    void testPayWithZeroAmount() {
        CreditCardPaymentStrategy strategy = new CreditCardPaymentStrategy("4111111111111111");
        boolean result = strategy.pay(0.0);
        assertTrue(result);
    }

    @Test
    void testPayWithLargeAmount() {
        CreditCardPaymentStrategy strategy = new CreditCardPaymentStrategy("5500-0000-0000-0004");
        boolean result = strategy.pay(9999.99);
        assertTrue(result);
    }

    @Test
    void testPayWithDecimalAmount() {
        CreditCardPaymentStrategy strategy = new CreditCardPaymentStrategy("378282246310005");
        boolean result = strategy.pay(49.99);
        assertTrue(result);
    }


    @Test
    void testNameReturnsCreditcard() {
        CreditCardPaymentStrategy strategy = new CreditCardPaymentStrategy("1234567890123456");
        assertEquals("creditcard", strategy.name());
    }

    @Test
    void testImplementsPaymentInterface() {
        CreditCardPaymentStrategy strategy = new CreditCardPaymentStrategy("1234567890123456");
        assertTrue(strategy instanceof Payment);
    }

    @Test
    void testWithDifferentCardNumberFormats() {
        CreditCardPaymentStrategy strategy1 = new CreditCardPaymentStrategy("1234567890123456");
        CreditCardPaymentStrategy strategy2 = new CreditCardPaymentStrategy("1234-5678-9012-3456");
        CreditCardPaymentStrategy strategy3 = new CreditCardPaymentStrategy("1234 5678 9012 3456");
        
        assertTrue(strategy1.pay(10.0));
        assertTrue(strategy2.pay(20.0));
        assertTrue(strategy3.pay(30.0));
        assertEquals("creditcard", strategy1.name());
        assertEquals("creditcard", strategy2.name());
        assertEquals("creditcard", strategy3.name());
    }

    @Test
    void testPayAlwaysReturnsTrue() {
        CreditCardPaymentStrategy strategy = new CreditCardPaymentStrategy("4111111111111111");
        assertTrue(strategy.pay(1.0));
        assertTrue(strategy.pay(100.0));
        assertTrue(strategy.pay(0.01));
        assertTrue(strategy.pay(10000.0));
    }
}