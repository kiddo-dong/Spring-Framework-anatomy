package main;

import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        /*
        // bean 등록 확인을 위한 목록 출력
        String beanList[] = context.getBeanDefinitionNames();
        for(String name : beanList){
            System.out.println(name);
        }
        */
        // 로직이 잘 동작하는지 test
        Comment comment = new Comment();
        comment.setAuthor("dh6559");
        comment.setText("댓글남기구가요~~~");

        var commentService = context.getBean(CommentService.class);
        commentService.publish(comment);
    }
}
