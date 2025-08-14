package service;

import org.springframework.stereotype.Component;

@Component("bank")
public class BankPaymentService implements PaymentService{
    @Override
    public void pay() {
        System.out.println("은행 결제 처리 완료");
    }
}
