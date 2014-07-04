package com.epam.jjp.aop.aspects;

public interface IAspectLog {
	void BeforeMethod(); // Run before the method execution

	void AfterMethod(); // Run after the method returned a result

	String AfterReturningMethod(); // Run after the method returned a result,
									// intercept the returned result as well.

	void AfterThrowingMethod(); // Run after the method throws an exception

	void AroundMethod(); // Run around the method execution, combine all three
							// advices above.
}
