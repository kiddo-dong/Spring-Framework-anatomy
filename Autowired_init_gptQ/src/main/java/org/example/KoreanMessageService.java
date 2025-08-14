package org.example;

import org.springframework.stereotype.Component;

@Component
public class KoreanMessageService implements MessageService{
    @Override
    public String printMessage(){
        return "안녕하세요 동현형님";
    }
}
