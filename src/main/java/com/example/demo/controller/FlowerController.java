package com.example.demo.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.flower.Flower;
import com.example.demo.flower.FlowerType;
import com.example.demo.flower.FlowerColor;

@RestController
public class FlowerController {

    @GetMapping("/flowers")
    public List<Flower> getFlowers() {
            return List.of(
                new Flower(10, FlowerColor.BLUE, 100, FlowerType.TULIP)
            );
    }
}
