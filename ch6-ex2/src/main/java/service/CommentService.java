package service;

import domain.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

//AOP 판별로 ../service 폴더는 proxy 객체로 이용됨
@Service
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publish(Comment comment){
        logger.info("Publishing Comment : " + comment.getText());
        return "SUCCESS";
    }
}
