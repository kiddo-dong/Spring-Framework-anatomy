package service;

import org.springframework.stereotype.Component;

@Component("kakao")
public class KakaoNotifier implements Notifier{
    @Override
    public void send(String message) {
        System.out.println("[Kakaos]" + message);
    }
}
