package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var cs1 = context.getBean("commentService", CommentService.class);
        var cs2 = context.getBean("commentService", CommentService.class);

        boolean b1 = cs1 == cs2;
        System.out.println(b1);

        String BeanList[] = context.getBeanDefinitionNames();
        for(String name : BeanList){
            System.out.println(name);
        }
    }
}
