package service;


import org.springframework.stereotype.Component;

@Component
public class CreditCardPayment implements PaymentMethod {

    @Override
    public void pay(int amount) {
        System.out.println("신용카드로 " + amount + "원 결제 완료");
    }

    @Override
    public String getName() {
        return "CreditCardPayment";
    }
}
