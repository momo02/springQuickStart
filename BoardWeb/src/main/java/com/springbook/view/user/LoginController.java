package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");
		
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
		ModelAndView mav = new ModelAndView();
		if(user != null){ //로그인 성공
			//View 이름 앞에 'redirect:'를 붙이면 ViewResolver가 설정되 있더라도 이를 무시하고 리다이렉트 
			mav.setViewName("redirect:getBoardList.do");  
		}else{  //로그인 실패
			mav.setViewName("redirect:login.jsp"); 
		}
		return mav;
	}

}
