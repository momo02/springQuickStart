package com.springbook.biz.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/*
Mybatis를 이용하여 DAO를 구현하려면 SqlSession객체가 필요하고
이 SqlSession객체를 얻으려면 SqlSessionFactory객체가 필요..
==> SqlSessionFactory객체를 생성하는 유틸리티 클래스 작성 
	: 모든 DAO클래스에서 좀 더 쉽게 SqlSession 객체를 획득할 수 있도록 공통으로 제공할 유틸리티 클래스
*/
public class SqlSessionFactoryBean {
	private static SqlSessionFactory sessionFactory = null;
	static { //cf.초기화 블럭(initialization block)
		//static { } :클래스 초기화 블럭 => 클래스 변수의 복잡한 초기화에 사용된다. 클래스가 처음 로딩될 때 한번만 수행된다.
		//{ } : 인스턴스 초기화 블럭 => 인스턴스 변수의 복잡한 초기화에 사용된다. 인스턴스가 생성될때 마다 수행된다. (생성자보다 먼저 수행된다.)
		try{
			if(sessionFactory == null){
				//Mybatis메인 설정 파일인 "sql-map-config.xml"파일로부터 설정 정보를 읽어 들이기 위한 입력스트림을 생성.
				//"sql-map-config.xml"파일을 로딩하려면 입력 스트림인 Reader객체가 필요.
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
				//입력 스트림을 통해 sql-map-config.xml파일을 읽어 SqlSessionFactory객체를 생성.
				//build()메소드는 Mybatis설정파일을 로딩하여 SqlSessionFactory객체를 생성한다.
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//SqlSessionFactory객체로부터 SqlSession객체를 얻어내어 리턴.
	public static SqlSession getSqlSessionInstance(){
		return sessionFactory.openSession(); 
	}
	
}
