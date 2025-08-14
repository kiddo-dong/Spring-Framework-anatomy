package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(CarConfig.class);

        Car c = context.getBean(Car.class);
        c.getName("911");
        System.out.println(c.Drive());

        BeanCar beanC1 = context.getBean("BeanCar", BeanCar.class);
        beanC1.setName("B1");
        System.out.println(beanC1.getName());
        beanC1.Beandrive();

        System.out.println();

        BeanCar beanC2 = context.getBean("BeanCar2",BeanCar.class);
        beanC2.setName("B2");
        System.out.println(beanC2.getName());
        beanC2.Beandrive();
    }
}