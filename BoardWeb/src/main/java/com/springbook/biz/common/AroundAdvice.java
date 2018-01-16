package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("[BEFORE]: 비즈니스 메소드 수행 전에 처리할 내용...");
		Object returnObj = pjp.proceed(); //비즈니스 메소드를 호출
		//pjp.proceed()메소드 호출 앞에 작성된 코드는 Before 어드바이스와 동일하게 동작. 
		// 					      뒤에 작성된 코드는 After 어드바이스와 동일하게 동작.
		System.out.println("[AFTER]: 비즈니스 메소드 수행 후에 처리할 내용...");
		return returnObj;
	}
}
