package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.PaymentServiceManager;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        /*
        //BeanList
        int BeanCount = 0;

        String BeanList[] = context.getBeanDefinitionNames();
        for(String name : BeanList){
            System.out.println("Bean["+ BeanCount++ +"] : " + name);
        }
        */

        var payment = context.getBean(PaymentServiceManager.class);
        payment.paymentPublish("card");
        payment.paymentPublish("bank");
        payment.paymentPublish("kakaopay");

    }
}