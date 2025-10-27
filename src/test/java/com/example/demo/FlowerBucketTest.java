package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.flower.Flower;
import com.example.demo.flower.FlowerBucket;
import com.example.demo.flower.FlowerPack;
import com.example.demo.flower.Rose;
import com.example.demo.flower.Tulip;

import org.junit.jupiter.api.Assertions;

public class FlowerBucketTest {
    private FlowerBucket flowerBucket;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
    }

    @Test
    public void testSinglePackPrice() {
        Flower flower = new Rose();
        flower.setPrice(10);
        FlowerPack pack = new FlowerPack(flower, 100);
        flowerBucket.add(pack);
        Assertions.assertEquals(1000, flowerBucket.getPrice(), 0.0001);
    }

    @Test
    public void testMultiplePacksPrice() {
        Flower rose = new Rose();
        rose.setPrice(5);
        Flower tulip = new Tulip();
        tulip.setPrice(3);

        FlowerPack pack1 = new FlowerPack(rose, 10);   // 50
        FlowerPack pack2 = new FlowerPack(tulip, 20);  // 60
        flowerBucket.add(pack1);
        flowerBucket.add(pack2);

        Assertions.assertEquals(110, flowerBucket.getPrice(), 0.0001);
    }

    @Test
    public void testEmptyBucketPrice() {
        Assertions.assertEquals(0, flowerBucket.getPrice(), 0.0001);
    }

    @Test
    public void testBucketDoesNotChangeWhenPackModified() {
        Flower flower = new Rose();
        flower.setPrice(2);
        FlowerPack pack = new FlowerPack(flower, 5); // 10
        flowerBucket.add(pack);

        double initialPrice = flowerBucket.getPrice();
        pack = new FlowerPack(flower, 10); // change pack, but not added again
        Assertions.assertEquals(initialPrice, flowerBucket.getPrice(), 0.0001);
    }

    @Test
    public void testAddingMultipleSamePackReferences() {
        Flower flower = new Rose();
        flower.setPrice(2);
        FlowerPack pack = new FlowerPack(flower, 5);
        flowerBucket.add(pack);
        flowerBucket.add(pack);
        Assertions.assertEquals(20, flowerBucket.getPrice(), 0.0001);
    }
}
