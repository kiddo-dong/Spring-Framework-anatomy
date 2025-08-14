package service;

import model.Comment;
import org.springframework.stereotype.Component;

@Component("Email")
public class EmailCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void CommentNotification(Comment comment) {
        System.out.println("Email : " + comment.getText() );
    }
}
