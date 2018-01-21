<%@ page import="com.springbook.biz.user.impl.UserDAO" %>
<%@ page import="com.springbook.biz.user.UserVO" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
	//1.사용자 입력 정보 추출
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//2.DB 연동 처리
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	//3.화면 네비게이션
	if(user != null){ //로그인 성공
		response.sendRedirect("getBoardList.jsp");  
		//forward 테스트
		//RequestDispatcher rd = request.getRequestDispatcher("getBoardList.jsp");
		//rd.forward(request, response);
	
	}else{  //로그인 실패
		response.sendRedirect("login.jsp"); 
	}
	
%>
	