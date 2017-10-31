package com.aa.beans;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String methodName = null;
		Object[] args = null;
		methodName = methodInvocation.getMethod().getName();
		args = methodInvocation.getArguments();

		// Entering into add(10,20)
		// Generic logic to getAll arguments at runtime
		/*
		 * System.out.print("Entering into "+methodName+"("); for(int
		 * i=0;i<args.length;i++) { if(i == 0) { System.out.print(args[i]);
		 * continue; } System.out.print(","+args[i]); } System.out.println(")");
		 */

		// log statements before execution
		System.out.println("Entering into method: " + methodName + "(" + args[0] + "," + args[1] + ")");

		// modify arguments before calling
		args[0] = (Integer) args[0] + 1;
		args[1] = (Integer) args[1] + 1;

		// calls the target method
		Object ret = null;
		ret = methodInvocation.proceed();

		// log statement after execution
		System.out.println("Exiting from " + methodName + " with ret " + ret);

		// modify the return value
		ret = (Integer) ret + 1;

		return ret;
	}
}