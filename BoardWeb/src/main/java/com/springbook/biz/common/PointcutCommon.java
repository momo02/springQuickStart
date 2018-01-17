package com.springbook.biz.common;

import org.aspectj.lang.annotation.Pointcut;

//어드바이스 클래스마다 포인트컷 설정이 포함되면서, 비슷하거나 같은 포인트컷이 반복 선언되는 문제 발생
// => 포인트컷을 외부에 독립된 클래스에 따로 설정
public class PointcutCommon {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut(){}

	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointcut(){}
}
