package com.aop.spring.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(* com.aop.spring.springaop.ProductServiceImpl.multiply(..))")
	public void getBefore(JoinPoint joint) {
		System.out.println("Before method call...");
	}

	@After("execution(* com.aop.spring.springaop.ProductServiceImpl.multiply(..))")
	public void getAfter(JoinPoint joint) {
		System.out.println("After method call..");
	}

}
