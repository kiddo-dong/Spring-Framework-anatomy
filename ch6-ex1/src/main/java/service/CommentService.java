package service;

import model.Comment;
import org.springframework.stereotype.Service;
import java.util.logging.Logger; // JDK의 logger

@Service
public class CommentService {
    public Logger logger = Logger.getLogger(CommentService.class.getName());

    public void publishComment(Comment comment){
        logger.info("Publishing comment : " + comment.getText());
        // INFO 로그 남음
    }
}
