package com.example.monolith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the modular monolith application.
 * 
 * @author b_muth
 *
 */
@SpringBootApplication
public class MonolithicApplication {
	public static void main(String[] args) {
		SpringApplication.run(MonolithicApplication.class, args);
	}
}