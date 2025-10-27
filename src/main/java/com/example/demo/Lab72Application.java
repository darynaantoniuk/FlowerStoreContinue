package com.example.demo;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Lab72Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab72Application.class, args);
	}

	@GetMapping("/List")
	public List<String> getRandomUUIDs() {
		UUID.randomUUID();
		return Stream.generate(() -> UUID.randomUUID())
		.map(UUID::toString)
		.limit(10)
		.toList();
	}

}
