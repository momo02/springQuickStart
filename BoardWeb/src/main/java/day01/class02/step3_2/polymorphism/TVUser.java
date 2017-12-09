package day01.class02.step3_2.polymorphism;

public class TVUser {
	public static void main(String[] args){
		
		//TV tv = new SamsungTV(); // TV인터페이스 타입의 변수로 SamsungTV객체를 참조.(묵시적 형변환)
		TV tv = new LgTV();  //==> 참조하는 객체만 변경하면 되므로 객체를 쉽게 교체할 수 있다.
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		

	}
}
