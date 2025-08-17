package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class NotificationAspect {
    private Logger logger = Logger.getLogger(NotificationAspect.class.getName());

    @Around("@annotation(annotation.LogExecution)")
    public Object NotificationServiceAspect(ProceedingJoinPoint joinPoint) throws Throwable{
            long startTime = System.currentTimeMillis();
            Object result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();

            logger.info(joinPoint.getSignature() + "\n시작시간 : " + startTime + "ms" +
                    "\n종료시간 : " + endTime + "ms" +
                    "\n실행 시간 : " + (endTime - startTime) + "ms"
                    );
        return result;
    }
}
