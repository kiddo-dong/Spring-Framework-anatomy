package service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentServiceManager {
    private final Map<String, PaymentService> paymentServiceMap;

    public PaymentServiceManager(Map<String, PaymentService> paymentServiceMap) {
        this.paymentServiceMap = paymentServiceMap;
    }

    public void PaymentPublish(String type, int amount){
        PaymentService paymentService = paymentServiceMap.get(type);
        if(paymentService != null){
            paymentService.pay(amount);
        } else {
            System.out.println("wrong type");
        }
    }
}
