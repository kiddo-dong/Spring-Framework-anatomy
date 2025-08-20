package service;

import annotation.PayLoggin;
import org.springframework.stereotype.Component;

@Component("cash")
public class CashPaymentService implements PaymentService{
    @PayLoggin
    @Override
    public void pay(int amount) {
        System.out.println("현금 " + amount + "원 결제 완료");
    }
}
