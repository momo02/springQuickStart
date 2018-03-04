package com.springbook.biz.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BoardServiceClient {
	public static void main(String[] args){
		//EntityManager 생성
		//영속성 유닛(persistence-unit)을 이용하여 EntityManagerFactory객체를 생성.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject"); //persistence-unit name
		//JPA를 이용하여 CRUD기능을 구현하려면 EntityManager객체를 사용해야하고 이 객체는 EntityManagerFactory객체로부터 얻어낼 수 있다.
		EntityManager em = emf.createEntityManager();
		
		//Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try{
			//Transaction 시작
			tx.begin();
			
			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA 글 등록 잘 되네요.");
			
			//글 등록 
			em.persist(board);
			
			//글 목록 조회
			String jpql = "select b from Baord b order by b.seq desc";
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			for(Board brd : boardList){
				System.out.println("---> "+brd.toString());
			}
			//Transaction commit
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			em.close();
		}
		emf.close();
	}
}
