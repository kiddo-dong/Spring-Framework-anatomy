package org.example;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private String name;

    public String getName(String name) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String Drive(){
        return "car " + name + " 출발";
    }
}
