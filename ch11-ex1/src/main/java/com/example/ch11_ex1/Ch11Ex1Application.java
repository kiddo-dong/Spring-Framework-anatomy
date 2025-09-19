package com.example.ch11_ex1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Ch11Ex1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch11Ex1Application.class, args);
	}

}
