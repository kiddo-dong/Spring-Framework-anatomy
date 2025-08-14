package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    
    // 코드의 안정성을 위해서 final로 객체변경이 불가능하게 지정
    private final Parrot parrot;

    // 생성자에서 @Autowired로 DI (가장 권장하는 방법)
    @Autowired
    public Person(Parrot parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    // ex6
    //@Autowired
    //public void setParrot(Parrot parrot) { this.parrot = parrot;}
}
