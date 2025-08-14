package service;

import org.springframework.stereotype.Component;

@Component("fixed")
public class FixedDiscountPolicy implements DiscountPolicy{
    @Override
    public int discount(int amount) {
        return 0;
    }
}