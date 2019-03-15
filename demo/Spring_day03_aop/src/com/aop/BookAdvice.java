package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component(value="bookAdvice")
@Aspect
public class BookAdvice {
	@Before(value="execution(* com.aop.Book.*(..))")
	public void before(){
		System.out.println("前置增强......");
	}
	@AfterReturning(value="execution(* com.aop.Book.*(..))")
	public void after(){
		System.out.println("后置增强......");
	}
	@Around(value="execution(* com.aop.Book.*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("方法之前......");
		//执行被增强的方法
		joinPoint.proceed();
		System.out.println("方法之后......");
	}
}
