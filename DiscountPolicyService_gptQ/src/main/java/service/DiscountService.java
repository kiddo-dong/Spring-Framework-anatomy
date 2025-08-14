package service;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DiscountService {
    private final Map<String, DiscountPolicy> discountPolicyMap;

    public DiscountService(Map<String, DiscountPolicy> discountPolicyMap) {
        this.discountPolicyMap = discountPolicyMap;
    }

    void discount(String type, int amount){
        DiscountPolicy discountPolicy = discountPolicyMap.get(type);

    }
}
