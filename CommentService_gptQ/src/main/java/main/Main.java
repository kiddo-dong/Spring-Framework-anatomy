package main;

import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var comment = context.getBean(CommentService.class);

        Comment comment1 = new Comment();
        comment1.setText("adadadasdasdasdsdasdasd");

        comment.publish("Email", comment1);

    }
}
