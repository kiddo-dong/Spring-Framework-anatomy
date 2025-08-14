package service;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotificationService {
    private final Map<String, Notifier>  notifierMap;
    
    // 생성자 하나로 @Autowire 생략
    public NotificationService(Map<String, Notifier> notifierMap) {
        this.notifierMap = notifierMap;
    }
    // Map으로 구현체 목록을 받음
        
    public void notify(String type, String message){
        notifierMap.get(type).send(message);
    }

}
