package day01.class02.step3_3.polymorphism;

public class SamsungTV implements TV {
	
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
