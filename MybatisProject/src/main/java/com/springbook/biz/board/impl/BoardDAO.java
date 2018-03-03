package com.springbook.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.util.SqlSessionFactoryBean;

public class BoardDAO {
	private SqlSession mybatis;
	
	public BoardDAO(){
		//SqlSession객체를 get
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	//SqlSession객체의 메소드를 이용하여 CRUD기능의 메소드를 모두 구현.
	//각 메소드의 첫번째 인자는 실행될 SQL의 id정보(SQL Mapper에 선언된 네임스페이스와 아이디를 조합하여 야이디를 지정),
	//두번째 인자는 parameterType속성으로 지정된 파라미터 객체
	public void insertBoard(BoardVO vo){
		mybatis.insert("BoardDAO.insertBoard",vo);
		mybatis.commit();
	}
	
	public void updateBoard(BoardVO vo){
		mybatis.update("BoardDAO.updateBoard",vo);
		mybatis.commit();
	}
	
	public void deleteBoard(BoardVO vo){
		mybatis.delete("BoardVO.deleteBoard",vo);
		mybatis.commit();
	}
	
	public BoardVO getBoard(BoardVO vo){
		return (BoardVO)mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		return mybatis.selectList("BoardDAO.getBoardList",vo);
	}
	
}
