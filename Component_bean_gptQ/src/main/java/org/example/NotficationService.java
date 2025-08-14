package org.example;

import org.springframework.stereotype.Component;

@Component
public class NotficationService {
    public String send(){
        return "알림 전송 완료";
    }
}
