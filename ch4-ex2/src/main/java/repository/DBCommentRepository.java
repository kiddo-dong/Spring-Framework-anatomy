package repository;

import model.Comment;
import org.springframework.stereotype.Component;

@Component
public class DBCommentRepository implements CommentRepository{
    @Override
    public void storeComment(Comment comment){
        System.out.println("댓글 저장 : " + comment.getText());
    }
}
