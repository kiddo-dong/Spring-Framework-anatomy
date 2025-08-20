package service;

import annotation.PayLoggin;
import org.springframework.stereotype.Component;

@Component("creditcard")
public class CreditCardPaymentService implements PaymentService{

    @PayLoggin
    @Override
    public void pay(int amount) {
        System.out.println("신용카드로 " + amount + "원 결제 완료");
    }
}
