package service;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CommentService {
    private final Map<String, CommentNotificationProxy> commentNotificationProxyMap;

    @Autowired
    public CommentService(Map<String, CommentNotificationProxy> commentNotificationProxyMap) {
        this.commentNotificationProxyMap = commentNotificationProxyMap;
    }

    public void publish(String commentNotificationProxyImplement ,Comment comment){
        commentNotificationProxyMap.get(commentNotificationProxyImplement).CommentNotification(comment);
    }
}
