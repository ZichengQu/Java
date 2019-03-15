package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class BookAdvice {
	public void before(){
		System.out.println("前置增强......");
	}
	public void after(){
		System.out.println("后置增强......");
	}
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("方法之前......");
		//执行被增强的方法
		joinPoint.proceed();
		System.out.println("方法之后......");
	}
}
