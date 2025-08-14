package service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

// bean 즉시 생성
@Service
// bean 지연 생성
@Lazy
public class CommentService {
    public CommentService(){
        System.out.println("service.CommentService Bean Created!");
    }
}
