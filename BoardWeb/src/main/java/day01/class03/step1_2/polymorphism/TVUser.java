package day01.class03.step1_2.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args){
		
		//1.Spring 컨테이너를 구동한다.
		//환경설정 파일인 applicationContext.xml을 로딩하여 스프링 컨테이너 중 하나인 GenericXmlApplicationContext를 구동
		// 컨테이너가 구동되는 시점에 스프링 설정 파일에 등록된 bean들을 생성하는 즉시 로딩(pre-loding) 방식으로 동작.. 
		System.out.println("........서블릿 컨테이너 구동");
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("........서블릿 컨테이너로 부터 객체를 요청"); //bean의 lazy-init속성이 "true"로 설정되어있으면 클라이언트가 요청하는 시점에 객체 생성 
		//2.Spring 컨테이너로부터 필요한 객체를 요청(Lookup)한다.
		TV tv = (TV)factory.getBean("tv"); //bean id로 요청.
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		//3.Spring 컨테이너를 종료한다.
		// 컨테이너가 종료되기 직전에 컨테이너는 자신이 관리하는 모든 객체를 삭제 
		// 이때 각 bean의 destroy-method속성으로 지정한 메소드가 각 객체가 삭제되기 직전에 호출된다.
		factory.close();
	}
}
