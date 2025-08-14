package service;

import domain.Comment;
import org.springframework.stereotype.Component;

@Component("nontext")
public class nonTextComment implements CommentServiceInterface{
    @Override
    public String SelectComment(Comment comment) {
        return "nontext : "+ comment.getText();
    }
}
