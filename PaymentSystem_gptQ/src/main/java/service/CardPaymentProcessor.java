package service;

import org.springframework.stereotype.Component;

@Component("card")
public class CardPaymentProcessor implements PaymentProcessor{
    @Override
    public void process(int amount) {
        System.out.println("card payment");
    }
}
