package com.springbook.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

/**
 * 
 * DAO 클래스 구현 방법 1.
 * SqlSessionDaoSupport클래스를 상속하여 구현.
 */
@Repository
public class BoardDAOMybatis extends SqlSessionDaoSupport{
	
	@Autowired //메소드 위에 @Autowired를 붙이면 
	//스프링 컨테이너가 setSqlSessionFactory()메소드를 자동으로 호출한다.
	//이때, 스프링 설정파일(applicationContext.xml)에 <bean>등록된 SqlSessionFactoryBean객체를 인자로 받는다. 
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		//부모인 SqlSessionDaoSupport에 setSqlSessionFactory()메소드로 설정해준다.
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	// ==> 이렇게 해야 SqlSessionDaoSupport클래스로부터 상속된 getSqlSession()메소드를 호출하여 SqlSession객체를 리턴받을 수 있다.
	
	public void insertBoard(BoardVO vo){
		System.out.println("===> Mybatis로 insertBoard() 기능 처리"); 
		getSqlSession().insert("BoardDAO.insertBoard",vo);
	}
	
	public void updateBoard(BoardVO vo){
		System.out.println("===> Mybatis로 updateBoard() 기능 처리");
		getSqlSession().update("BoardDAO.updateBoard",vo);
	}
	
	public void deleteBoard(BoardVO vo){
		System.out.println("===> Mybatis로 deleteBoard() 기능 처리");
		getSqlSession().delete("BoardVO.deleteBoard",vo);
	}
	
	public BoardVO getBoard(BoardVO vo){
		System.out.println("===> Mybatis로 getBoard() 기능 처리");
		return (BoardVO)getSqlSession().selectOne("BoardDAO.getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===> Mybatis로 getBoardList() 기능 처리");
		return getSqlSession().selectList("BoardDAO.getBoardList",vo);
	}
}

