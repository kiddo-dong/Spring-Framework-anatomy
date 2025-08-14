package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        Owner o = context.getBean(Owner.class);
        System.out.println("고양이 주인 : " + o.getName() + " 고양이 : " + o.getCat().getName() );
    }
}