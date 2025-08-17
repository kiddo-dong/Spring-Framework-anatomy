package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.NotificationServiceManager;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        /*
        //BeanList
        String Beans[] = context.getBeanDefinitionNames();
        for(String name : Beans){
            System.out.println(name);
        }
        System.out.println();
        */

        NotificationServiceManager notificationServiceManager = context.getBean(NotificationServiceManager.class);

        notificationServiceManager.NotificationPublish("email", "회원가입 완료");
        notificationServiceManager.NotificationPublish("sms", "인증번호 발송");


    }
}
