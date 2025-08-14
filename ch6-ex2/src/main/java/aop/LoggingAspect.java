package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

//@Component 또는 @Bean으로 컨텍스트에 빈 추가
@Aspect //aspect 지정 (부가 구성)
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    // 가로챌 메소드 경로
    @Around("execution(* service.*.*(..))") //service 폴더의 모든 Bean을 위빙하여 proxy로 사용
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Method will execute");
        joinPoint.proceed(); // service
        logger.info("Method executed");

    }
}
