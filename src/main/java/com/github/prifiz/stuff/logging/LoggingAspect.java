package com.github.prifiz.stuff.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;


@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);

    @Pointcut("within(com.github.prifiz.stuff.web.controller..*)")
    public void controllerClassMethods() {
    }

    @Pointcut("execution(* *.*(..))")
    protected void allMethod() {
    }

    @Around("controllerClassMethods()")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("[AOP LOGGER] Calling method: " + proceedingJoinPoint.getSignature());
        long currentTime = new Date().getTime();
        Object result = proceedingJoinPoint.proceed();
        long executionTime = new Date().getTime() - currentTime;
        LOGGER.info(String.format("[AOP LOGGER] Took %s millis", executionTime));
        return result;
    }
}
