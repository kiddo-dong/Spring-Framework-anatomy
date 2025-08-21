package com.example.ch7_ex1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.logging.Logger;

/*
Main Class
*/
@SpringBootApplication // @SpringBootApplication에서 spring-boot Main 클래스를 정의
public class Ch7Ex1Application {
	// main method
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Ch7Ex1Application.class.getName());
		ConfigurableApplicationContext context = SpringApplication.run(Ch7Ex1Application.class, args);

		System.out.println("context Type : " + context.getClass().getName());

		logger.info("=== 등록된 Bean 목록 ===");
		Arrays.stream(context.getBeanDefinitionNames())
				.sorted()
				.forEach(System.out::println);

		context.close();
	}
}