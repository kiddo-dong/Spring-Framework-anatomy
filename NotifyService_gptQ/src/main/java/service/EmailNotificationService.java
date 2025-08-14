package service;

import domain.Notification;
import org.springframework.stereotype.Component;

@Component("email")
public class EmailNotificationService implements NotificationServiceInterface{
    @Override
    public void send(Notification notification) {
        System.out.println(notification.getTo() +"에게 Email message: " + notification.getMessage());
    }
}
