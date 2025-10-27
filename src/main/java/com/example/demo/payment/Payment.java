package com.example.demo.payment;


public interface Payment {
    boolean pay(double amount);
    String name();
}