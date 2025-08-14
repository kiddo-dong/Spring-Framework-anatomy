package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);

        NotficationService notficationService = context.getBean(NotficationService.class);

        System.out.println(notficationService.send());
    }
}