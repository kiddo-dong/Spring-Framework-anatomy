package service;

import org.springframework.stereotype.Component;

@Component
public class BankTransferPayment implements PaymentMethod {

    @Override
    public void pay(int amount) {
        System.out.println("은행이체로 " + amount + "원 결제 완료");
    }

    @Override
    public String getName() {
        return "BankTransferPayment";
    }
}
