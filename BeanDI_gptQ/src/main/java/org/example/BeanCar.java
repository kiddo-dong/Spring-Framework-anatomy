package org.example;

import org.springframework.context.annotation.Bean;

public class BeanCar {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void Beandrive() {
        System.out.println("choi car");
    }
}
