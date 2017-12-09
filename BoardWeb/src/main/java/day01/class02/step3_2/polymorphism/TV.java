package day01.class02.step3_2.polymorphism;

//TV클래스들의 최상위 부모로 사용할 TV인터페이스 추가.
public interface TV {
	//모든 TV가 공통으로 가져야 할 메소드들을 추상메소드로 선언. 
	public void powerOn();
	public void powerOff();
	public void volumeUp();
	public void volumeDown();
}
