package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@Order(2)
public class LoggingAspect {
    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around(value = "@annotation(annotation.LogExecution)")
    public Object Logging(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        logger.info("[" + joinPoint.getSignature().getName() +"] 메소드 실행 시간 : " + (endTime - startTime) +"ms");

        return result;
    }
}
