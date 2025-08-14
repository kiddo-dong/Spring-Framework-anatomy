package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Bean List
        String beanList[] = context.getBeanDefinitionNames();
        for (String name : beanList){
            System.out.println(name);
        }
        System.out.println();
        
        Parrot parrot = context.getBean(Parrot.class);
        Person person = context.getBean(Person.class);
        
        parrot.setName("코코");
        System.out.println("앵무새 이름 : "+ parrot.getName());
        
        person.setName("최동현");
        System.out.println(person.getName() + "의 앵무새 :" + person.getParrot().getName());
    }
}