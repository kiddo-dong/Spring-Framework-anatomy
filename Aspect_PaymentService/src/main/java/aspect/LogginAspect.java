package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LogginAspect {
    private final Logger logger = Logger.getLogger(LogginAspect.class.getName());

    @Around("@annotation(annotation.PayLoggin)")
    public Object PaymentServiceLogger(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("결제시작");
        Object paymentObject = joinPoint.proceed();
        logger.info("결제종료");
        return  paymentObject;
    }
}