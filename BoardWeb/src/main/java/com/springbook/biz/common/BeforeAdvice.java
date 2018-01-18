package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	
	//@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	//public void allPointcut(){}
	
	//Before 어드바이스
	@Before("PointcutCommon.allPointcut()") //외부 클래스에 선언된 포인트컷 참조
	public void beforeLog(JoinPoint jp){
		
		String method = jp.getSignature().getName(); //클라이언트가 호출한 메서드 명 리턴 
		Object[] args = jp.getArgs(); //클라이언트가 메소드를 호출할 때 넘겨준 인자 목록을 Object 배열로 리턴 
		
		System.out.println("[사전 처리] "+method+"() 메소드 ARGS 정보 : " + args[0].toString());
	}
}
