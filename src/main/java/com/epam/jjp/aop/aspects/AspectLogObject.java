package com.epam.jjp.aop.aspects;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectLogObject implements IAspectLog {
	private long begin;

	@Before("execution(* com.epam.jjp.aop.domain.Battle.start(..))")
	public void BeforeMethod(JoinPoint joinPoint) {
		System.out.println("*****The battle has started!*****");
		begin = new Date().getTime();
	}

	@After("execution(* com.epam.jjp.aop.domain.Battle.start(..))")
	public void AfterMethod(JoinPoint joinPoint) {
		System.out.println("*****The battle has ended!*****\n[It lasted "
				+ (new Date().getTime() - begin) + " milliseconds]");

	}

	@AfterReturning(pointcut = "execution(* com.epam.jjp.aop.domain.Battle.getWinnerCorp(..))", returning = "result")
	public void AfterReturningMethod(JoinPoint joinPoint, Object result) {

	}

	@AfterThrowing("execution(* com.epam.jjp.aop.domain.Battle.start(..))")
	public void AfterThrowingMethod(JoinPoint joinPoint) {

	}

	@Around("execution(* com.epam.jjp.aop.domain.Battle.start(..))")
	public void AroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		joinPoint.proceed();
	}

}
