package org.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SmsNotificationService implements NotificationSercvice{
    @Override
    public void send(String message){
        System.out.println("문자 발송 : " + message);
    }
}
