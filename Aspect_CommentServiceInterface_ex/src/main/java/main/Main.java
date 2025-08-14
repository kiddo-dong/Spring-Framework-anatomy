package main;

import domain.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CommentService;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Main.class.getName());

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);


        // BeanList logging
        int countBeanHashMapIdx = 0;
        String BeanList[] = context.getBeanDefinitionNames();
        for(String name : BeanList) {
            logger.info("countBeanHashMapIdx [" + countBeanHashMapIdx++ + "] : " + name);
        }
        logger.info("\n");

        // @EnableAspectJAutoProxy context 추가로
        // context에 internalAutoProxyCreator가 Bean으로 등록된것을 확인
        // [0-3] springframework Bean
        // [4-6] Bean
        // [7] BeanPostProcessor(AOP판별 후처리기)

        Comment comment = new Comment();
        comment.setAuthor("dh");
        comment.setText("Logger Print");
        /*
        // CommentService는 AOP 대상이므로 proxy return;
        CommentService commentService = context.getBean(CommentService.class);
        logger.info(commentService.publish(comment));
        */

        var commentService = context.getBean(CommentService.class);
        commentService.publish("text", comment);
        commentService.publish("nontext", comment);
        commentService.publish("sdsds", comment);

    }+
}
