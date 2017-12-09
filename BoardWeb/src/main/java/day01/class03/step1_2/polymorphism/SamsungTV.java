package day01.class03.step1_2.polymorphism;

import day01.class03.step1_2.polymorphism.TV;

public class SamsungTV implements TV {
	public SamsungTV(){ //생성자
		System.out.println("===> SamsungTV 객체 생성");
	}
	
	public void initMethod(){
		System.out.println("객체 초기화 작업 처리..");
	}

	public void destroyMethod(){
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
	}
	
	//TV 인터페이스에 선언된 추상 메소드들을 모두 재정의해야만 한다.
	public void powerOn(){
		System.out.println("SamsungTV---전원 켠다.");
	}
	
	public void powerOff(){
		System.out.println("SamsungTV---전원 끈다.");
	}
	
	public void volumeUp(){
		System.out.println("SamsungTV---소리 올린다.");
	}
	
	public void volumeDown(){
		System.out.println("SamsungTV---소리 내린다.");
	}
}
 