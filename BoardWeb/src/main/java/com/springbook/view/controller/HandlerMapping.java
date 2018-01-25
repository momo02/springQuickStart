package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

//모든 Controller객체들을 저장하고 있다가,클라이언트의 요청이 들어오면 요청을 처리할 특정 Controller를 검색하는 기능을 제공.
//DispatcherServlet이 사용하는 객체. 
//따라서 DispatcherServlet이 생성되고 init()메소드가 호출될 때 단 한 번 생성.
public class HandlerMapping {
	private Map<String,Controller> mappings;
	
	public HandlerMapping(){
		mappings = new HashMap<String,Controller>();
		mappings.put("/login.do", new LoginController());
	}
	
	public Controller getController(String path){
		return mappings.get(path);
	}
	
}
