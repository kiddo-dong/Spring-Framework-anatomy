package main;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import service.CommentService;

@Configuration
public class ProjectConfig {

    @Bean
    // @Scope 프로토타입으로 참조 마다 인스턴스 생성
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CommentService commentService(){
        return new CommentService();
    }
}
