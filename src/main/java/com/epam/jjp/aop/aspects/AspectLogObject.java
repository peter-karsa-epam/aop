package com.epam.jjp.aop.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectLogObject implements IAspectLog {

	@Before("execution(* com.epam.jjp.aop.domain.Battle.start(..))")
	public void BeforeMethod() {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!The battle has started!!!!!!!!!!!!!!!!!!!!!");
	}

	@After("execution(* com.epam.jjp.aop.domain.Battle.start(..))")
	public void AfterMethod() {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!The battle has ended!!!!!!!!!!!!!!!!!!!!!!!");

	}

	//@AfterReturning
	public String AfterReturningMethod() {
		return null;
		// TODO Auto-generated method stub

	}

	//@AfterThrowing
	public void AfterThrowingMethod() {
		// TODO Auto-generated method stub

	}

	//@Around()
	public void AroundMethod() {
		// TODO Auto-generated method stub

	}

}
