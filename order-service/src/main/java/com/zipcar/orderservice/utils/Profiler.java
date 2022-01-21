package com.zipcar.orderservice.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class Profiler {

    @Around("@annotation(Profile)")
    public Object logExecutionTime(final ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("EXECUTION STARTS for {}", joinPoint.getSignature());
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final Object proceed = joinPoint.proceed();
        stopWatch.stop();
        log.info("EXECUTION of {}{}{}{}", joinPoint.getSignature(), " TAKEN ", stopWatch.getTotalTimeMillis(), " ms");
        return proceed;
    }
}