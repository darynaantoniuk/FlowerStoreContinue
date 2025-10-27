package com.example.demo.flower;
/**
 * Represents a pack of flowers, including the flower type
 * and the quantity in the pack.
 */
public class FlowerPack {

    /** The flower contained in the pack. */
    private Flower flower;

    /** The number of flowers in the pack. */
    private int amount;

    /**
     * Constructs a flower pack with a specified flower and quantity.
     *
     * @param flower the flower in the pack
     * @param amount the number of flowers
     */
    public FlowerPack(final Flower flower, final int amount) {
        this.flower = flower;
        this.amount = amount;
    }

    /**
     * Copy constructor to create a new flower pack from an existing pack.
     *
     * @param pack the flower pack to copy
     */
    public FlowerPack(final FlowerPack pack) {
        this.flower = new Flower(pack.flower);
        this.amount = pack.amount;
    }

    /**
     * Returns the total price of the flower pack.
     *
     * @return total price
     */
    public double getPrice() {
        return flower.getPrice() * amount;
    }
}
