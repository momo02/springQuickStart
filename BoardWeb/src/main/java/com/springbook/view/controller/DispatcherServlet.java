package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HandlerMapping handlerMapping; 
    private ViewResolver viewResolver;
    
    //서블릿의 init()메소드는 서블릿 객체가 생성된 후에 멤버변수를 초기화하기 위해 자동으로 실행.
	public void init() throws ServletException{
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글이 깨지지 않도록 인코딩 처리 (모든 요청에 대해 공통 처리)
		process(request,response);
	}
	
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//1.클라이언트이 요청 path 정보를 추출한다.
		String uri = request.getRequestURI();
		System.out.println("uri>>>>>" + uri);
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		//2.HandlerMapping을 통해  path에 해당하는 Controller를 검색한다.
		Controller ctrl = handlerMapping.getController(path);
		
		//3.검색된 Controller를 실행한다.
		String viewName = ctrl.handleRequest(request, response);
		
		//4.ViewResolver를 통해 viewName에 해당하는 화면을 검색한다.
		String view = null;
		if(!viewName.contains(".do")){
			view = viewResolver.getView(viewName);
		}else{
			view = viewName;
		}
		
		//5.검색된 화면으로 이동한다.
		response.sendRedirect(view);
		
	}

}
