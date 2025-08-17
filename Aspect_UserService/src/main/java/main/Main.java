package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserServiceManager;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        /*
        //beanList
        String beanList[] = context.getBeanDefinitionNames();
        for(String name : beanList){
            System.out.println(name);
        }
        System.out.println();
        */
        UserServiceManager userServiceManager = context.getBean(UserServiceManager.class);
        userServiceManager.userServicePublish("user","dh6559");
        userServiceManager.userServicePublish("user", "dddd");

5000
    }
}
