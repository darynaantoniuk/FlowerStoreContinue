package com.example.demo.flower;

import lombok.Data;

@Data
public class Item {
    private FlowerBucket flowerBucket;
    public double getPrice(){
        return flowerBucket.getPrice();
    }
}
