package com.softsurroundings.soft.surroundings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SoftSurroundingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftSurroundingsApplication.class, args);
	}

}
