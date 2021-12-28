package project.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class AspectLogger {
    private Logger log = Logger.getLogger(getClass().toString());

    @Pointcut("execution(* project.rest.MainRestController.*(..))")
    public void calledAtMainREstController(){}

    @After("calledAtMainREstController()")
    public void log(JoinPoint point) {
        log.info(point.getSignature().getName() + " called...");
    }

    @Pointcut("execution(* project.rest.DeviceRestController.*(..))")
    public void calledAtDeviceRestController(){}

    @After("calledAtDeviceRestController()")
    public void log2(JoinPoint point) {
        log.info(point.getSignature().getName() + " called...");
    }

    @Pointcut("execution(* project.rest.UserRentRestController.*(..))")
    public void calledAtUserRentRestController(){}

    @After("calledAtUserRentRestController()")
    public void log3(JoinPoint point) {
        log.info(point.getSignature().getName() + " called...");
    }
}
