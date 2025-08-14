package service;

import org.springframework.stereotype.Component;

@Component("sms")
public class SmsNotifier implements Notifier{
    @Override
    public void send(String message) {
        System.out.println("[sms]" + message);
    }
}
