package com.zipcar.orderservice.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogErrorAspect {

	private static final Logger log = LoggerFactory.getLogger(LogErrorAspect.class);

	@AfterThrowing(pointcut = "@annotation(LogError)", throwing = "e")
	public void logError(JoinPoint joinPoint, Throwable e) {
		log.error("*** Exception occured at : " + joinPoint.getSignature(), e);
	}
}
