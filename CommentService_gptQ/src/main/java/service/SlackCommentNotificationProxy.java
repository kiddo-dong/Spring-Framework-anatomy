package service;

import model.Comment;
import org.springframework.stereotype.Component;

@Component("Slack")
public class SlackCommentNotificationProxy implements CommentNotificationProxy{
    @Override

    public void CommentNotification(Comment comment) {
        System.out.println("slack : " + comment.getText());
    }
}
