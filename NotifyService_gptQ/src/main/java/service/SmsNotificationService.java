package service;

import domain.Notification;
import org.springframework.stereotype.Component;

@Component("sms")
public class SmsNotificationService implements NotificationServiceInterface{
    @Override
    public void send(Notification notification) {
        System.out.println(notification.getTo() +"에게 Sms message: " + notification.getMessage());
    }
}
