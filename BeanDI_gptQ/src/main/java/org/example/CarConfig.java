package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("org.example")
public class CarConfig {
    // @Component @Component 로직에서 Spring이 객체를 자동 생성
    // Car ComponentScan으로 Bean 자동 주입

    // @Bean 객체 생성 후 직접 주입
    // BeanCar
    @Bean
    BeanCar BeanCar(){
        BeanCar bc = new BeanCar();
        return bc;
    }

    @Bean
    BeanCar BeanCar2(){
        BeanCar bc2 =new BeanCar();
        return bc2;
    }
}
