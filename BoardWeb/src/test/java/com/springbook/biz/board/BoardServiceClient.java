package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args){
		//1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring 컨테이너로부터 BoardServiceImpl객체를 Lookup한다.
		BoardService boardService = (BoardService)container.getBean("boardService");
		
		//3. 글 등록 기능 테스트
		BoardVO vo = new BoardVO();
		vo.setTitle("방금쓴글제목");
		vo.setWriter("차은우");
		vo.setContent("내용~~~");
		boardService.insertBoard(vo);

		//4. 글 목록 검색 기능 테스트
		//검색 조건 설정
		BoardVO vo1 = new BoardVO();
		vo1.setSearchCondition("TITLE");
		vo1.setSearchKeyword("방금쓴");
		List<BoardVO> boardList = boardService.getBoardList(vo1);
		for(BoardVO board : boardList){
			System.out.println("---> " + board.toString());
		}
		
		//5. Spring 컨테이너 종료
		container.close();
	}
}
