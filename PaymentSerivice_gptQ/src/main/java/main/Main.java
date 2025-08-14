package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.PaymentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        PaymentService p = context.getBean(PaymentService.class);
        p.processPayment("BankTransferPayment", 10000);
    }
}
