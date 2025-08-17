package service;

import org.springframework.stereotype.Component;

@Component("card")
public class CardPayService implements PaymentService{
    @Override
    public void pay(int amount) {
        System.out.println("card 결제");
    }
}
