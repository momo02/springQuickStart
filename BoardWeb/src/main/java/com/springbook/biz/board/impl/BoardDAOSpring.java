package com.springbook.biz.board.impl;

import java.util.Date;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

//DAO(Data Access Object)
@Repository
public class BoardDAOSpring{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//SQL 명령어들 
	private final String BOARD_INSERT = "insert into board(seq,title,writer,content,regdate) values((select nvl(max(seq),0)+1 from board),?,?,?,?)";
	//private final String BOARD_INSERT = "insert into board(seq,title,writer,content) values(?,?,?,?)";  //트랜잭션 테스트 
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	//private final String BOARD_LIST = "select * from board order by seq desc";
	private final String BOARD_LIST_T = "select * from board where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_C = "select * from board where content like '%'||?||'%' order by seq desc";
	
	//CRUD 기능의 메소드 구현
	//글 등록 
	public void insertBoard(BoardVO vo){
		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리"); 
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getRegDate()); //트랜잭션 테스트 
	}
	
	//글 수정
	public void updateBoard(BoardVO vo){
		System.out.println("===> Spring JDBC로 updateBoard() 기능 처리"); 
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
		
	}
	
	//글 삭제 
	public void deleteBoard(BoardVO vo){
		System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리"); 
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
		
	}
	
	//글 상세 조회
	public BoardVO getBoard(BoardVO vo){
		System.out.println("===> Spring JDBC로 getBoard()기능 처리");
		Object[] args = {vo.getSeq()};
		
		//queryForObject() : select 구문의 실행 결과를 특정 자바 객체(1개)로 매핑하여 리턴받을 때 사용.
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	//글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===> Spring JDBC로 getBoardList()기능 처리");
		//query() : select 구문의 실행 결과가 목록(여러개)일 때 사용.
		Object[] args = {vo.getSearchKeyword()};
		if("TITLE".equals(vo.getSearchCondition())){
			return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
		}else if("CONTENT".equals(vo.getSearchCondition())){
			return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
		}
		return null;
		
	}
}
