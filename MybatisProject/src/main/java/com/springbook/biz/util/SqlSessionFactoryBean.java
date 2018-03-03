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
*/
public class SqlSessionFactoryBean {
	private static SqlSessionFactory sessionFactory = null;
	static {
		try{
			if(sessionFactory == null){
				//Mybatis메인 설정 파일인 "sql-map-config.xml"파일로부터 설정 정보를 읽어 들이기 위한 입력스트림을 생성.
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
				//입력 스트림을 통해 sql-map-config.xml파일을 읽어 SqlSessionFactory객체를 생성.
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
