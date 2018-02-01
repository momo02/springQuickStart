package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	/* ModelAttribute가 설정된 메소드는 @RequestMapping이 적용된 메소드보다 먼저 호출.
	   해당 메소드 실행 결과로 리턴된 객체는 자동으로 Model에 저장되어, View페이지에서 사용 가능. */
	//검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String,String> searchConditionMap(){
		Map<String,String> conditionMap = new HashMap<String,String>();
		
		conditionMap.put("제목","TITLE");
		conditionMap.put("내용","CONTENT");
		return conditionMap;
	}
	
	//글 등록
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO){
		boardDAO.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	//글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo,BoardDAO boardDAO) {
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	//글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo,BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	//글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo,BoardDAO boardDAO, Model model) {
		model.addAttribute("board", boardDAO.getBoard(vo)); 
		return "getBoard.jsp"; 
	}
	
	
	//글 목록 조회
	@RequestMapping("/getBoardList.do")
	public String getBoardList(@RequestParam(value="searchCondition",required=false) String condition,
							   @RequestParam(value="searchKeyword",required=false) String keyword,
							   BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("검색 조건 : " + condition);
		System.out.println("검색 단어 : " + keyword);
		//		model.addAttribute("boardList", boardDAO.getBoardList(vo)); 
		return "getBoardList.jsp";
	}
}
