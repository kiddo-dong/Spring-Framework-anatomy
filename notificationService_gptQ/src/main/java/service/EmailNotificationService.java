package service;

import model.Message;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationService implements NotificationService{
    @Override
    public void sendNotification(Message message) {
        System.out.println("이메일 알림 : " + message.getText());
    }
}
