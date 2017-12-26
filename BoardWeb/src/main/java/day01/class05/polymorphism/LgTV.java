package day01.class05.polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {

 //1. @Autowired
	//@Qualifier("apple") //Speaker타입의 객체가 2개 이상일 때, 의존성 주입될 객체의 id나 name을 지정.
	//private Speaker speaker;
	
 //2. @Resource(name="sony")
	//private Speaker speaker;
	
	@Autowired
	private Speaker speaker;
	
	public LgTV(){
		System.out.println("===> LgTV 객체 생성");
	}
	//TV 인터페이스에 선언된 추상 메소드들을 모두 재정의해야만 한다.
	public void powerOn() {
		System.out.println("LgTV---전원 켠다.");
	}

	public void powerOff() {
		System.out.println("LgTV---전원 끈다.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
	
	
}
