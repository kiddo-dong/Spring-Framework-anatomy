package service;

import annotation.LogExecution;
import org.springframework.stereotype.Component;

@Component("sms")
public class SmsNotificationService implements NotificationService{
    @Override
    @LogExecution
    public void send(String message) {
        System.out.println("SMS 발송 : " + message);
    }
}
