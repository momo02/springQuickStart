package day01.class02.step3_3.polymorphism;

public class TVUser {
	public static void main(String[] args){

		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(args[0]); 
		//BeanFactory클래스의 getBean()메소드는 
		//매개변수로 받은 beanName에 해당하는 객체를 생성하여 리턴 
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		

	}
}
