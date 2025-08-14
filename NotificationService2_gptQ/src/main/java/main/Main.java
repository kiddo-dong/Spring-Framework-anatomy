package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.NotificationService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        String BeanList[] = context.getBeanDefinitionNames();
        for(String name : BeanList){
            System.out.println(name);
        }
        System.out.println();

        var notifyBean = context.getBean(NotificationService.class);
        notifyBean.notify("sms", "메시지 입니다.");
        notifyBean.notify("email", "메시지 입니다.");
        notifyBean.notify("kakao","메시지 입니다.");
    }
}
