package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
	//@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	//public void getPointcut(){}
	
	//AfterReturning 어드바이스
	@AfterReturning(pointcut="PointcutCommon.getPointcut()",returning="returnObj"/*메소드 리턴값을 저장할 바인드 변수 지정*/) 
	public void afterLog(JoinPoint jp,Object returnObj){ //2번째 매개변수 =>바인드 변수: 비즈니스 메소드가 리턴한 결괏값을 바인딩할 목적으로 사용.
		
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof UserVO){
			UserVO user = (UserVO)returnObj;
			if(user.getRole().equals("Admin")){
				System.out.println(user.getName() + "로그인(Admin)");
			}
		}
		System.out.println("[사후 처리] "+ method + "() 메소드 리턴값 : "+ returnObj.toString());
	}
}
