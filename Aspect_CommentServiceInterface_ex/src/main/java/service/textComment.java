package service;

import domain.Comment;
import org.springframework.stereotype.Component;

@Component("text")
public class textComment implements CommentServiceInterface{
    @Override
    public String SelectComment(Comment comment) {
        return "text : " + comment.getText();
    }
}
