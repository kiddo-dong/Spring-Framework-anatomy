package service;

import model.Message;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SmsNotificationService implements NotificationService{
    @Override
    public void sendNotification(Message message){
        System.out.println("문자 알림 : " + message.getText());
    }
}