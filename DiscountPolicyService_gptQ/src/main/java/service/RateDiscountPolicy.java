package service;

import org.springframework.stereotype.Component;

@Component("rate")
public class RateDiscountPolicy implements DiscountPolicy{
    @Override
    public int discount(int amount) {
        return 0;
    }
}
