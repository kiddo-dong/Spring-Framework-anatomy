package service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.logging.Logger;

@Service
public class NotificationServiceManager {
    private final Map<String, NotificationService> notificationServiceMap;
    private final Logger logger = Logger.getLogger(NotificationServiceManager.class.getName());

    public NotificationServiceManager(Map<String, NotificationService> notificationServiceMap) {
        this.notificationServiceMap = notificationServiceMap;
    }


    public void NotificationPublish(String type, String message){
        NotificationService notificationService = notificationServiceMap.get(type);
        if(notificationService != null){
            notificationService.send(message);
        } else {
            logger.warning("지원하지 않는 발송 형식");
        }
    }
}
