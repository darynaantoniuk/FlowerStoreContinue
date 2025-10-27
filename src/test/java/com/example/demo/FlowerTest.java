package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.flower.Chamomile;
import com.example.demo.flower.Flower;
import com.example.demo.flower.FlowerColor;
import com.example.demo.flower.FlowerType;
import com.example.demo.flower.Rose;
import com.example.demo.flower.Tulip;

import org.junit.jupiter.api.Assertions;

public class FlowerTest {

    @Test
    public void testSetAndGetPrice() {
        Flower f = new Rose();
        f.setPrice(15);
        Assertions.assertEquals(15, f.getPrice());
    }

    @Test
    public void testColorToString() {
        Flower f = new Tulip();
        f.setColor(FlowerColor.BLUE);
        Assertions.assertEquals("#0000FF", f.getColor());
    }

    @Test
    public void testSepalLengthSetter() {
        Flower f = new Chamomile();
        f.setSepalLength(5.5);
        Assertions.assertEquals(5.5, f.getSepalLength());
    }

    @Test
    public void testCopyConstructor() {
        Flower f = new Rose();
        f.setSepalLength(7);
        f.setPrice(10);
        f.setColor(FlowerColor.RED);
        f.setFlowerType(FlowerType.ROSE);

        Flower copy = new Flower(f);
        Assertions.assertEquals(f.getPrice(), copy.getPrice());
        Assertions.assertEquals(f.getSepalLength(), copy.getSepalLength());
        Assertions.assertEquals(f.getColor(), copy.getColor());
    }
}
