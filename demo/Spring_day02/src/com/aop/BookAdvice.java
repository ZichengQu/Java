package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class BookAdvice {
	public void before(){
		System.out.println("ǰ����ǿ......");
	}
	public void after(){
		System.out.println("������ǿ......");
	}
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("����֮ǰ......");
		//ִ�б���ǿ�ķ���
		joinPoint.proceed();
		System.out.println("����֮��......");
	}
}
