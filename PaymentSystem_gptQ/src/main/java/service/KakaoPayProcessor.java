package service;

import org.springframework.stereotype.Component;

@Component("kakaopay")
public class KakaoPayProcessor implements PaymentProcessor{
    @Override
    public void process(int amount) {
        System.out.println("kakaopay payment");
    }
}
