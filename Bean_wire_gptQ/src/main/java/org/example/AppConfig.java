package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    Cat cat(){
        Cat c = new Cat();
        c.setName("춘식이");
        return c;
    }

    @Bean
    Owner owner(Cat cat){ // 수동으로 DI
        Owner o = new Owner();
        o.setName("동현");
        o.setCat(cat);
        return o;
    }
}
