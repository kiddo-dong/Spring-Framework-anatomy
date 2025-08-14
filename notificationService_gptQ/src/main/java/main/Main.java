package main;

import manager.NotificationManager;
import model.Message;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(config.class);

        Message message = new Message();
        message.setText("dlkdkewkm");

        var notification = context.getBean(NotificationManager.class);
        notification.notifyUser(message);
    }
}
