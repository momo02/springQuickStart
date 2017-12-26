package day01.class05.polymorphism;

import org.springframework.stereotype.Component;

//@Component("sony") //->주석 처리하여 객체가 자동으로 생성되는 것을 차단
public class SonySpeaker implements Speaker {
	public SonySpeaker(){
		System.out.println("===> SonySpeaker 객체 생성");
	}
	
	public void volumeUp(){
		System.out.println("SonySpeaker---소리 올린다.");
	}
	
	public void volumeDown(){
		System.out.println("SonySpeaker---소리 내린다.");
	}
}
