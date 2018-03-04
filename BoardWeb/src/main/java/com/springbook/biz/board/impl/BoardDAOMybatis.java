package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

/**
 * 
 * Mybatis를 이용하여 DAO 클래스 구현 방법 2.
 * 스프링 설정 파일에 SqlSessionTemplate클래스를 bean등록하고,
 * DAO클래스에서 SqlSessionTemplate객체를 @Autowired를 이용하여 의존성 주입 처리.
 * => SqlSessionTemplate객체로 DB연동 로직을 처리. 
 */
@Repository
public class BoardDAOMybatis{
	
	@Autowired 
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo){
		System.out.println("===> Mybatis로 insertBoard() 기능 처리"); 
		mybatis.insert("BoardDAO.insertBoard",vo);
	}
	
	public void updateBoard(BoardVO vo){
		System.out.println("===> Mybatis로 updateBoard() 기능 처리");
		mybatis.update("BoardDAO.updateBoard",vo);
	}
	
	public void deleteBoard(BoardVO vo){
		System.out.println("===> Mybatis로 deleteBoard() 기능 처리");
		mybatis.delete("BoardVO.deleteBoard",vo);
	}
	
	public BoardVO getBoard(BoardVO vo){
		System.out.println("===> Mybatis로 getBoard() 기능 처리");
		return (BoardVO)mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===> Mybatis로 getBoardList() 기능 처리");
		return mybatis.selectList("BoardDAO.getBoardList",vo);
	}
}

