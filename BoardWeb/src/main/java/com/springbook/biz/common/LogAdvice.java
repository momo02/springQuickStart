package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect //스프링 컨테이터가 에스팩트 객체로 인식.
public class LogAdvice {
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut(){} //참조 메소드->여러 포인트컷을 식별하기 위한 식별자
	 							//(구현X.어떤 기능 처리를 목적으로 하지않고 단순히 포인트컷을 식별하는 이름으로만 사용)

//	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
//	public void getPointcut(){}
	
	@Before("allPointcut()")//어드바이스 어노테이션 뒤에 괄호를 추가하고 포인트컷 참조 메소드를 지정.
	public void printLog(){
		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
	}
}
