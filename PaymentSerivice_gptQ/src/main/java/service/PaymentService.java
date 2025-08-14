package service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PaymentService {
    private final Map<String, PaymentMethod> paymentMethodMap = new HashMap<>();

    public PaymentService(List<PaymentMethod> methods) {
        for (PaymentMethod method : methods) {
            paymentMethodMap.put(method.getName(), method); // getName()으로 key 설정!
        }
    }

    public void processPayment(String methodName, int amount) {
        PaymentMethod method = paymentMethodMap.get(methodName);
        if (method == null) {
            System.out.println("지원하지 않는 결제 방식입니다: " + methodName);
            return;
        }
        method.pay(amount);
    }
}
