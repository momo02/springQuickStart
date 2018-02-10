package com.springbook.view.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
				   
@ControllerAdvice("com.springbook.view") //이 어노테이션에 의해 CommonExceptionHandler 객체가 자동 생성
@EnableWebMvc
public class CommonExceptionHandler {
	
	//"com.springbook.view" 패키지로 시작하는 컨트롤러에서 예외가 발생하는 순간 
	// @ExceptionHandler 어노테이션으로 지정한 메소드가 실행됨. 
	// 어떤 예외가 발생했느냐에 따라 다른 메소드가 수행..
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handleArithmeticException(Exception e){ //산술 예외 처리
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("/common/arithmeticError.jsp");
		return mav;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleNullPointerException(Exception e){
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("/common/nullPointerError.jsp");
		return mav;
	}
	
//	@ExceptionHandler(IllegalArgumentException.class)
//	public ModelAndView handleIllegalArgumentException(Exception e){
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception",e);
//		mav.setViewName("/common/illegalArgumentError.jsp");
//		return mav;
//	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e){
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("/common/error.jsp");
		return mav;
	}
	
}
