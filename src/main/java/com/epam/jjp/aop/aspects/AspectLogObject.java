package com.epam.jjp.aop.aspects;

public class AspectLogObject implements IAspectLog {

	public void BeforeMethod() {
		System.out.println("The battle has started!");
	}

	public void AfterMethod() {
		System.out.println("The battle has ended!");

	}

	public String AfterReturningMethod() {
		return null;
		// TODO Auto-generated method stub

	}

	public void AfterThrowingMethod() {
		// TODO Auto-generated method stub

	}

	public void AroundMethod() {
		// TODO Auto-generated method stub

	}

}
