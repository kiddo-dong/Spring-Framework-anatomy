package service;

import org.springframework.stereotype.Component;

@Component("card")
public class CardPaymentService implements PaymentService{
    @Override
    public void pay() {
        System.out.println("카드 결제 처리 완료");
    }
}
