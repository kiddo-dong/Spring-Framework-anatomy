package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.PaymentServiceManager;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        PaymentServiceManager p = context.getBean(PaymentServiceManager.class);
        p.PaymentPublish("creditcard",111111);
        p.PaymentPublish("cash", 1212122);
    }
}
