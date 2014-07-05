package com.epam.jjp.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public interface IAspectLog {
	void BeforeMethod(final JoinPoint joinPoint); // Run before the method
													// execution

	void AfterMethod(final JoinPoint joinPoint); // Run after the method
													// returned a
	// result

	void AfterReturningMethod(final JoinPoint joinPoint, Object result); // Run
	// after
	// the
	// method
	// returned
	// a
	// result,
	// intercept the returned result as well.

	void AfterThrowingMethod(final JoinPoint joinPoint); // Run after the method
	// throws an exception

	void AroundMethod(final ProceedingJoinPoint joinPoint) throws Throwable; // Run
																				// around
																				// the
																				// method
																				// execution,
	// combine all three
	// advices above.
}
