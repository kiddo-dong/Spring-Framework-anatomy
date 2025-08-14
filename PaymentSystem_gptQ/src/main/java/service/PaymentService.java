package service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentService {
    private final Map<String, PaymentProcessor> PayStringPaymentProcessorMap;

    public PaymentService(Map<String, PaymentProcessor> payStringPaymentProcessorMap) {
        PayStringPaymentProcessorMap = payStringPaymentProcessorMap;
    }

    public void pay(String type, int amount){
        PaymentProcessor paymentProcessor = PayStringPaymentProcessorMap.get(type);
        if(paymentProcessor != null){
            paymentProcessor.process(amount);
        }
        else {
            System.out.println("잘못 입력된 결제 수단 입니다.");
        }
    }
}
