package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;

    //@qualifier("bean 이름") 으로 같은 class 인스턴스 존재 시 DI할 bean 지정 가능
    @Autowired // Autowired로 Parrot 클래스 자동 DI
    private Parrot parrot;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }
    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}
