package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        //context를 실행시키면 Person 과 Parrot의 Bean이 서로 순환의존성에 의해 교착상태 error 가 출력된다.
    }
}