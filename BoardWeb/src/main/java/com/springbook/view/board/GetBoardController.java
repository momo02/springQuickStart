package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController{

	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo,BoardDAO boardDAO,ModelAndView mav) {
		System.out.println("글 상세 조회 처리");
		
		BoardVO board = boardDAO.getBoard(vo);
		
		//3.검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴한다.
		mav.addObject("board",board); //Model 정보 저장
		mav.setViewName("getBoard"); //View 정보 저장 
		return mav;
		
	}
	
	

}
