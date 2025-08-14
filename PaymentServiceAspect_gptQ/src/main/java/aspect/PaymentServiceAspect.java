package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Aspect
@Component
public class PaymentServiceAspect {
    private final Logger logger = Logger.getLogger(PaymentServiceAspect.class.getName());

    @Before("execution(* service.PaymentService.*(..))")
    public void PaymentServiceLog(JoinPoint joinPoint){
        logger.info("실행 구현체 : " + joinPoint.getTarget().getClass().getSimpleName());
    }
}
