package day01.class02.step3_1.polymorphism;

public class TVUser {
	public static void main(String[] args){
		
//		SamsungTV tv = new SamsungTV();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		//이제 SamsungTV를 시청하는 TVUser프로그램을 LgTV를 시청하는 프로그램으로 수정해보자.
		LgTV tv = new LgTV();
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();
		
		//SamsungTV와 LgTV는 메소드 시그니처(signature)가 다르므로 
		//TVUser 코드 대부분을 수정해서 TV를 교체할 수 있다. 
	}
}
