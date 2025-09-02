package com.example.UserMVC_gptQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
public class UserMvcGptQApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(UserMvcGptQApplication.class, args);
		Logger logger = Logger.getLogger(UserMvcGptQApplication.class.getName());
		int count = 1;

		logger.info("======== Bean List ========");

		String BeanList[] = context.getBeanDefinitionNames();
		for(String name : BeanList){
			logger.info("Bean["+ count++ +"] : " + name);
		}
	}
}
