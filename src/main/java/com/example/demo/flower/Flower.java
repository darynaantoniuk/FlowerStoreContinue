package com.example.demo.flower;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@AllArgsConstructor
public class Flower {

    @Getter
    private double sepalLength;
    private FlowerColor color;
    @Getter
    private double price;
    @Getter
    private FlowerType flowerType;

    public Flower() {
        sepalLength = 0;
        price = 0;
    }

    public Flower(final Flower flower) {
        sepalLength = flower.sepalLength;
        color = flower.color;
        price = flower.price;
        flowerType = flower.flowerType;
    }

    public String getColor() {
        return color.toString();
    }
}
