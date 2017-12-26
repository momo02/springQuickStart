package day01.class04.ioc.injection;

import java.util.Properties;
//import java.util.List;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	public static void main(String[] args){
		AbstractApplicationContext factory = new GenericXmlApplicationContext("context.xml");
		
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		Properties addressList = bean.getAddressList();
		//List,Set타입일 경우 
//		for(String address : addressList){
//			System.out.println(address.toString());
//		}
		
		System.out.println(addressList.getProperty("고길동"));
		System.out.println(addressList.getProperty("마이콜"));
		
		factory.close();
	}
}
