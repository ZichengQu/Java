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
		System.out.println("ǰ����ǿ......");
	}
	@AfterReturning(value="execution(* com.aop.Book.*(..))")
	public void after(){
		System.out.println("������ǿ......");
	}
	@Around(value="execution(* com.aop.Book.*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("����֮ǰ......");
		//ִ�б���ǿ�ķ���
		joinPoint.proceed();
		System.out.println("����֮��......");
	}
}
