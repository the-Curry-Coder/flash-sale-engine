package com.thecurrycoder.flashsaleengine.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ControllerLoggingAspect {

    @Around("execution(* com.flashsaleengine.controller..*(..))")
    public Object logControllerExecution(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().toShortString();

        log.info("Started: {}", methodName);

        long startTime = System.currentTimeMillis();

        try {
            Object result = joinPoint.proceed();

            long endTime = System.currentTimeMillis();

            log.info("Completed: {} in {} ms",
                    methodName,
                    (endTime - startTime));

            return result;

        } catch (Exception ex) {

            log.error("Exception in {} : {}",
                    methodName,
                    ex.getMessage());

            throw ex;
        }
    }
}