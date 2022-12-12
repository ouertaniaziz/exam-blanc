package com.example.Ouertani.Med.Aziz.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

	@AfterReturning("execution( * com.example.Ouertani.Med.Aziz.controllers.*.*(..))")
	public void logMethodEntry(JoinPoint joinPoint) {

		String name = joinPoint.getSignature().getName();

		log.info(" Exécution :" + name + "est términé" );
	}

	

}	