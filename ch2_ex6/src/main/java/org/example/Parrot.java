package org.example;


import org.springframework.stereotype.Component;

// Parrot clss를 @Component 등록
// Spring Application Context의 내부 로직에서 Spring Bean

// 등록한 component를 configuration에서 scan이 필요함
// @Component와 @ComponentScan()
@Component
public class Parrot {
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
