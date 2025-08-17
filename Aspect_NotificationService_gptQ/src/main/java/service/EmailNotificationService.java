package service;

import annotation.LogExecution;
import org.springframework.stereotype.Component;

@Component("email")
public class EmailNotificationService implements NotificationService{


    @Override
    @LogExecution
    public void send(String message) {
        System.out.println("이메일 발송 : " + message);
    }
}
