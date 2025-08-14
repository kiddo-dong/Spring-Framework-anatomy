package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    // 2개의 객체 bean 주입(IoC, DI)
    @Bean
    Parrot parrot(){
        Parrot p = new Parrot();
        p.setName("koko");

        return p;
    }

    @Bean
    Person person(){
        Person p = new Person();
        p.setName("Ella");
        return p;
    }
}
