package service;

import domain.Comment;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());
    // Map<BeanName, Object(Bean)>
    private final Map<String, CommentServiceInterface> commentServiceInterfaceMap;

    public CommentService(Map<String, CommentServiceInterface> commentServiceInterfaceMap) {
        this.commentServiceInterfaceMap = commentServiceInterfaceMap;
    }

    public void publish(String type, Comment comment){
        CommentServiceInterface commentServiceInterface = commentServiceInterfaceMap.get(type);
        if(commentServiceInterface != null){
            commentServiceInterface.SelectComment(comment);
        } else {
            logger.warning("존재하지 않는 type");
        }
    }
}
