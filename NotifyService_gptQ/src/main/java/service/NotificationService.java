package service;

import domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotificationService {
    private final Map<String, NotificationServiceInterface> NotifiStringNotificationServiceInterfaceMap;

    @Autowired // 생성자 NotifiStringNotificationServiceInterface 구현체 DI
    public NotificationService(Map<String, NotificationServiceInterface> notifiStringNotificationServiceInterfaceMap) {
        NotifiStringNotificationServiceInterfaceMap = notifiStringNotificationServiceInterfaceMap;
    }

    public void publish(String type, Notification notification){
        NotificationServiceInterface notificationServiceInterface = NotifiStringNotificationServiceInterfaceMap.get(type);
        if(notificationServiceInterface != null){
            notificationServiceInterface.send(notification);
        } else {
            System.out.println("wrong API path");
        }
    }

}
