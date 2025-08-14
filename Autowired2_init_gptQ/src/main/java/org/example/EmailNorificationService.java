package org.example;

import org.springframework.stereotype.Component;

@Component
public class EmailNorificationService implements NotificationSercvice{
    @Override
    public void send(String message){
        System.out.println("이메일 발송 : ");
    }
}
