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
	public void BeforeMethod(final JoinPoint joinPoint) {
		System.out.println("*****The battle has started!*****");
		begin = new Date().getTime();
	}

	@After("execution(* com.epam.jjp.aop.domain.Battle.start(..))")
	public void AfterMethod(final JoinPoint joinPoint) {
		System.out.println("*****The battle has ended!*****\n[It lasted "
				+ (new Date().getTime() - begin) + " milliseconds]");

	}

	@AfterReturning(pointcut = "execution(* com.epam.jjp.aop.domain.Battle.getWinnerCorp(..))", returning = "result")
	public void AfterReturningMethod(final JoinPoint joinPoint, Object result) {
		System.out.println("Result: " + result.toString());
	}

	@AfterThrowing("execution(* com.epam.jjp.aop.domain.Battle.start(..))")
	public void AfterThrowingMethod(final JoinPoint joinPoint) {
		System.out
				.println("There has been an unknown failure during the battle!");
	}

	@Around("execution(* com.epam.jjp.aop.domain.Battle.start(..))")
	public void AroundMethod(final ProceedingJoinPoint joinPoint)
			throws Throwable {
		System.out.println("Prepare for battle!");
		joinPoint.proceed();
		System.out.println("Who ever wins, we lose...");
	}

}
