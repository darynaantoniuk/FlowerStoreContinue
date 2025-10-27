package com.example.demo.payment;

public class CreditCardPaymentStrategy implements Payment {
    private final String cardNumber;

    public CreditCardPaymentStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Charging credit card " + cardNumber + " for amount = $" + amount);
        return true;
    }

    @Override
    public String name() {
        return "creditcard";
    }
}
