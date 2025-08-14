import org.springframework.stereotype.Service;

@Service
public class CommentService {
    public void sendComment(Comment c){
        CommentProcessor p = new CommentProcessor();
        p.setComment(c);
        p.processComment(c);
        p.validateComment(c);
        c = p.getComment();
    }
}
