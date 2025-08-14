package main;

import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        // CommentService Bean 꺼내옴
        var service = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setAuthor("Logger");
        comment.setText("Demo Comment");

        service.publishComment(comment);
        // 콘솔에 info() 메소드의 내용이 담김


    }
}
