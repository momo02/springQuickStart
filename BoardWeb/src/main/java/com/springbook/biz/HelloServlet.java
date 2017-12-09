package com.springbook.biz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	
	public HelloServlet(){
		System.out.println("===> HelloServlet 객체 생성");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		System.out.println("doGet()메소드 호출");
	}
}
//책에서는 servlet클래스가 web.xml에 자동으로 등록 된다고 나오는데 자동으로 등록안됨..??
