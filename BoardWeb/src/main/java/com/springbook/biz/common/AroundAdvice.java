package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


@Service
@Aspect
public class AroundAdvice {
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut(){}
	
	//AfterThrowing 어드바이스
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		String method = pjp.getSignature().getName();
		
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		
		//System.out.println("[BEFORE]: 비즈니스 메소드 수행 전에 처리할 내용...");
		Object returnObj = pjp.proceed(); //클라이언트가 호출한 비즈니스 메소드를 호출(실행)
		//pjp.proceed()메소드 호출 앞에 작성된 코드는 Before 어드바이스와 동일하게 동작. 
		// 					      뒤에 작성된 코드는 After 어드바이스와 동일하게 동작.
		//System.out.println("[AFTER]: 비즈니스 메소드 수행 후에 처리할 내용...");
		
		stopwatch.stop();
		System.out.println(method + "() 메소드 수행에 걸린 시간 : " +  stopwatch.getTotalTimeMillis()+"(ms)초");
		return returnObj;
	}
}
