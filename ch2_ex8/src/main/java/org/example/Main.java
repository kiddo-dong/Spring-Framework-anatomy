package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // 컨테이너 구성 추가
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        
        // 객체 생성 및 초기화
        Parrot x = new Parrot();
        x.setName("dh"); // field setting for test

        // 객체 인스턴스 반환
        Supplier<Parrot> parrotSupplier = () -> x;

        context.registerBean("parrot1", Parrot.class, parrotSupplier);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

    }
}