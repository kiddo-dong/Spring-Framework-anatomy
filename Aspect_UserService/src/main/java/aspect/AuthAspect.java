package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@Order(1)
public class AuthAspect {
    private final Logger logger = Logger.getLogger(AuthAspect.class.getName());

    @Around(value = "@annotation(annotation.AuthCheck)")
    public Object Auth(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("[" + joinPoint.getSignature().getName() + "] " + "인증 여부 확인중...");
        Object result = joinPoint.proceed();
        return result;
    }
}
