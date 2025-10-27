package com.example.demo.payment;

public class PayPalPaymentStrategy implements Payment {
    private final String email;

    public PayPalPaymentStrategy(String email) {
        this.email = email;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Charging PayPal account " + email + " for amount = $" + amount);
        return true;
    }

    @Override
    public String name() {
        return "paypal";
    }
}
