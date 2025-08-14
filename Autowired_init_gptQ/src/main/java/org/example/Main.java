package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        String BeanList[] = context.getBeanDefinitionNames();
        for(String name : BeanList){
            System.out.println(name);
        }

        MessagePrinter messagePrinter = context.getBean(MessagePrinter.class);
        System.out.println(messagePrinter.getMessageService().printMessage());
    }
}