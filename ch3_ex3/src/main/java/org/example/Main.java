package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 구성 추가
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        // bean 목록 로그
        int beanCount = 0;
        String[] beanList = context.getBeanDefinitionNames(); //정의된 Bean이름 목록 메소드(배열 return)
        for(String name : beanList) {
            System.out.println( "beanNumLog" + beanCount++ + " = " + name);
        }
        System.out.println();

        // 생성한 bean getName
        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println("Person Name = " + person.getName());
        System.out.println("Parrot Name = " + parrot.getName());
        //ex3
        System.out.println("Person's Parrot = " + person.getParrot().getName());
        
        /*
        //ex1-2
        // Null | has-A관계에서의 Person 객체가 아직 Parrot 객체를 소유하지 않음
        System.out.println("Person's Parrot = " + person.getParrot());
        System.out.println();

        // bean들을 이용하여 객체끼리의 관계 설정
        // person의 setParrot으로 Parrot 객체 주입;

        // Java 기반 수동 빈 연결
        // 두 객체간의 has-A 관계 형성됨
        person.setParrot(parrot);
        System.out.println("Person's Parrot = " + person.getParrot().getName());
        */
    }
}