package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import service.PaymentManager;
import service.PaymentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        // BeanList
        int beanMapIdx = 0;
        String beanList[] = context.getBeanDefinitionNames();
        for(String name : beanList){
            System.out.println("beanMapIdx["+ beanMapIdx++ +"] : "+name);
        }
        System.out.println();

        PaymentManager paymentManager = context.getBean(PaymentManager.class);
        paymentManager.payPublish("card", 13000);
        paymentManager.payPublish("kakaopay", 20000);
        paymentManager.payPublish("tosspay", 23400);
    }
}