package day01.class02.step3_3.polymorphism;

//디자인 패턴 이용.
//Factory패턴이 적용된 BeanFactory클래스.
public class BeanFactory {

	public Object getBean(String beanName){
		if(beanName.equals("samsung")){
			return new SamsungTV();
		}else if(beanName.equals("lg")){
			return new LgTV();
		}
		return null;
	}
}
