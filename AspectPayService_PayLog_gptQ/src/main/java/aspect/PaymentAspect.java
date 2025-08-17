package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import service.PaymentService;

import java.util.logging.Logger;

@Component
@Aspect
public class PaymentAspect {
    private final Logger logger = Logger.getLogger(PaymentAspect.class.getName());

    @Around("execution(* service.PaymentService.*(..))")
    public Object PaymentLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object paymentservice = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info(joinPoint.getSignature() + " 실행 시간: " + (endTime - startTime) + "ms");
        return paymentservice;
    }
}