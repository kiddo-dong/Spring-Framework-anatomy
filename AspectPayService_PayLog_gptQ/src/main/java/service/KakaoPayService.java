package service;

import org.springframework.stereotype.Component;

@Component("kakaopay")
public class KakaoPayService implements PaymentService{
    @Override
    public void pay(int amount) {
        System.out.println("kakaopay 결제");
    }
}
