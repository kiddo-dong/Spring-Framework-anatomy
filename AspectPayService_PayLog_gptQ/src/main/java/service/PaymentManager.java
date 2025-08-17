package service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.logging.Logger;

@Service
public class PaymentManager {
    private final Map<String, PaymentService> paymentServiceMap;
    private final Logger logger = Logger.getLogger(PaymentService.class.getName());

    public PaymentManager(Map<String, PaymentService> paymentServiceMap) {
        this.paymentServiceMap = paymentServiceMap;
    }

    public void payPublish(String type, int amount){
        PaymentService paymentService = paymentServiceMap.get(type);
        if(paymentService != null) {
            paymentService.pay(amount);
        } else {
            logger.warning("지원하지 않는 결제 서비스");
        }
    }
}
