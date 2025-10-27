package com.example.demo.flower;

public class FlowerPack {

    private Flower flower;

    private int amount;

    public FlowerPack(final Flower flower, final int amount) {
        this.flower = flower;
        this.amount = amount;
    }

    public FlowerPack(final FlowerPack pack) {
        this.flower = new Flower(pack.flower);
        this.amount = pack.amount;
    }

    public double getPrice() {
        return flower.getPrice() * amount;
    }
}
