package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


@Service
@Aspect
public class AfterThrowingAdvice {
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut(){}
	
	//AfterThrowing 어드바이스
	@AfterThrowing(pointcut="allPointcut()",throwing="exceptObj"/*예외 객체를 저장할 바인드 변수 지정*/) 
	public void exceptionLog(JoinPoint jp,Exception exceptObj){ //비즈니스 메소드에서 발생한 예외 객체를 exceptObj라는 바인드 변수를 통해 받음.
		
		String method = jp.getSignature().getName();
		//System.out.println("[예외 처리] "+ method + "() 메소드 수행 중 발생된 예외 메시지 : "+ exceptObj.getMessage());
		
		System.out.println(method + "() 메소드 수행 중 예외 발생!");
		
		//예외 객체의 종류에 따라 다양하게 예외 처리
		if(exceptObj instanceof IllegalArgumentException){
			System.out.println("부적합한 값이 입력되었습니다.");
		}else if(exceptObj instanceof NumberFormatException){
			System.out.println("숫자 형식의 값이 아닙니다");
		}else if(exceptObj instanceof Exception){
			System.out.println("문제가 발생했습니다");
		}
	}
}
