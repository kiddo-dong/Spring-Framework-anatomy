package main;
import domain.Notification;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.NotificationService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        int BeanCount = 0;
        // context BeanList
        String BeanList[] = context.getBeanDefinitionNames();
        for(String name : BeanList){
            System.out.println("BeanIdx ["+ BeanCount++ +"] : " + name);
        }
        //Bean 객체 비교
        var b1 = context.getBean("notificationService", NotificationService.class);
        var b2 = context.getBean("notificationService", NotificationService.class);

        System.out.println(b1 == b2);

        System.out.println();

        Notification notification = new Notification();
        notification.setTo("Hyo");
        notification.setMessage("test message");

        var notify = context.getBean(NotificationService.class);
        notify.publish("sms", notification);
        notify.publish("email", notification);
        notify.publish("kakao", notification);
    }
}
