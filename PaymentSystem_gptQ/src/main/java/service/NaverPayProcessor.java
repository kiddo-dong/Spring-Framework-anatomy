package service;

import org.springframework.stereotype.Component;

@Component("naverpay")
public class NaverPayProcessor implements PaymentProcessor{
    @Override
    public void process(int amount) {
        System.out.println("naverpay payment");
    }
}
