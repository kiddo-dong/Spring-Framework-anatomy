package com.example.ch8_ex5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
public class Ch8Ex5Application {
	public static void main(String[] args) {
		SpringApplication.run(Ch8Ex5Application.class, args);

		Logger logger = Logger.getLogger(Ch8Ex5Application.class.getName());
		logger.info("Spring-Framework : Starting...");

	}
}
