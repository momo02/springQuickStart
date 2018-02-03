package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board") //Model에 "board"라는 이름으로 저장되는 데이터가 있다면 
//그 데이터를 세션(HttpSession)에도 자동으로 저장하라는 설정
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
	public String updateBoard(@ModelAttribute("board") BoardVO vo,BoardDAO boardDAO) {
		// @ModelAttribute("board")설정을 해석하여 세션에 "board"라는 이름으로 저장된 데이터가 있는지를 확인.
		// 있으면 1.해당 객체를 세션에서 꺼내서 매개변수로 선언된 vo변수에 할당.
		// 2.사용자가 입력한 파라미터값을 vo객체에 할당.
		// ==> 사용자가 입력한 값만 새롭게 할당되고, 나머지는 상세보기를 했을때("/getBoard.do") 세션에 저장된 데이터가 유지 
		System.out.println("번호 : " + vo.getSeq());
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("작성자  : " + vo.getWriter());
		System.out.println("내용 : " + vo.getContent());
		System.out.println("등록일 : " + vo.getRegDate());
		System.out.println("조회수 : " + vo.getCnt());
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
		//System.out.println("검색 조건 : " + condition);
		//System.out.println("검색 단어 : " + keyword);
		model.addAttribute("boardList", boardDAO.getBoardList(vo)); 
		return "getBoardList.jsp";
	}
}
