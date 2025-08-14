package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Appconfig.class);

        NotificationManager notificationManager = context.getBean(NotificationManager.class);
        notificationManager.notifyUser("테스트 메시지");
    }
}