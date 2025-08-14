package main;

import POJO.Comment;
import proxies.CommentNotificationProxy;
import proxies.EmailCommentNotificationProxy;
import repository.CommentRepository;
import repository.DBCommentRepository;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        CommentRepository commentRepository = new DBCommentRepository();
        CommentNotificationProxy commentNotificationProxy = new EmailCommentNotificationProxy();

        CommentService commentService = new CommentService(commentRepository, commentNotificationProxy);

        Comment comment = new Comment();
        comment.setAuthor("최동동");
        comment.setText("asdasdasdsadasdasdsadasdsadasdasdasdgwsdgs");

        commentService.publishComment(comment);
    }
}
