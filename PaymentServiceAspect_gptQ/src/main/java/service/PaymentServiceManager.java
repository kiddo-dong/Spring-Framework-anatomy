package service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.logging.Logger;

@Service
public class PaymentServiceManager {
    private final Map<String, PaymentService> paymentServiceMap;
    
    private final Logger logger = Logger.getLogger(PaymentServiceManager.class.getName());
    
    public PaymentServiceManager(Map<String, PaymentService> paymentServiceMap) {
        this.paymentServiceMap = paymentServiceMap;
    }

    public void paymentPublish(String type){
        PaymentService paymentService = paymentServiceMap.get(type);
        if(paymentService != null){
            paymentService.pay();
        } else {
            logger.warning("지원하지 않는 결제 방식");
        }
    }
}
