﻿package day01.class03.step1_2.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser2 {
	public static void main(String[] args){
		//1.Spring IoC 컨테이너를 구동한다.
		//환경설정 파일인 applicationContext.xml을 로딩하여 스프링 컨테이너 중 하나인 GenericXmlApplicationContext를 구동
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2.Spring 컨테이너로부터 필요한 객체를 요청(Lookup)한다.
//		TV tv = (TV)factory.getBean("tv"); //bean id로 요청.
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		//3.Spring 컨테이너를 종료한다.
		factory.close();
	}
}
