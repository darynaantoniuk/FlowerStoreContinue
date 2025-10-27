package com.example.demo.flower;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import com.example.demo.delivery.Delivery;

@Data
public class Order {
    private List<Item> items;
    private Delivery delivery;

    public Order() {
        this.items = new ArrayList<>();
    }

    public double getOrderFinalPrice (){
        double finalPrice = items.stream().mapToDouble(Item::getPrice).sum();
        finalPrice += delivery.delivery(finalPrice);
        return finalPrice;
    }
    
}
