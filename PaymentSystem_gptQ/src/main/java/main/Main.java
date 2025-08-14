package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.PaymentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        var payment = context.getBean(PaymentService.class);

        payment.pay("card", 5000);
        payment.pay("kakaopay",100000);
        payment.pay("tosspay", 20000);
    }
}
