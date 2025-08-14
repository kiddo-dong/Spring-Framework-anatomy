package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String Name;
    private final Person person;

    @Autowired
    public Parrot(Person person) {
        this.person = person;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Person getPerson() {
        return person;
    }
}
