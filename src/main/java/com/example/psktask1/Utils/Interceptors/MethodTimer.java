package com.example.psktask1.Utils.Interceptors;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@ConditionalOnProperty(name = "time.tracking.enabled", havingValue = "true")
public class MethodTimer {

    @Around("@annotation(com.example.psktask1.Utils.Interceptors.Timed)")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();

        long startTime = System.currentTimeMillis();
        log.info("Execution STARTED - {}.{}", className, methodName);

        try {
            return joinPoint.proceed();
        } finally {
            long executionTime = System.currentTimeMillis() - startTime;
            log.info("Execution COMPLETED - {}.{} | Time: {} ms",
                    className, methodName, executionTime);
        }
    }
}
