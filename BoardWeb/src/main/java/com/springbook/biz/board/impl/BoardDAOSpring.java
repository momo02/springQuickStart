package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

//DAO(Data Access Object)
@Repository
public class BoardDAOSpring extends JdbcDaoSupport {
	//JdbcDaoSupport 부모클래스로부터 getJdbcTemplate()메소드를 상속받음.. 
	//메소드를 호출하면 JdbcTemplate객체가 리턴되어 모든 메소드를 jdbcTemplate객체로 구현 가능.
	
	//JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	//SQL 명령어들 
	private final String BOARD_INSERT = "insert into board(seq,title,writer,content) values((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	
	//getJdbcTemplete()메소드가 jdbcTemplate객체를 리턴하려면 DataSource객체를 가지고 있어야 함. 
	//따라서 반드시 부모 클래스인 JdbcDaoSupport클래스의 setDataSource()메소드를 호출하여 데이터 소스 객체를 의존성 주입해야함. 
	@Autowired  //==> applicationContext.xml 설정파일에 등록한 DataSource 빈이 주입됨.
	public void setSuperDataSource(DataSource dataSource){
		super.setDataSource(dataSource);
	}
	
	//CRUD 기능의 메소드 구현
	//글 등록 
	public void insertBoard(BoardVO vo){
//		System.out.println("===> JDBC로 insertBoard() 기능 처리"); 
//		try{
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_INSERT);
//			stmt.setString(1, vo.getTitle());
//			stmt.setString(2, vo.getWriter());
//			stmt.setString(3, vo.getContent());
//			stmt.executeUpdate();
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			JDBCUtil.close(stmt, conn);
//		}
		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리"); 
		getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	//글 수정
	public void updateBoard(BoardVO vo){
//		System.out.println("===> JDBC로 updateBoard() 기능 처리"); 
//		try{
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_UPDATE);
//			stmt.setString(1, vo.getTitle());
//			stmt.setString(2, vo.getContent());
//			stmt.setInt(3, vo.getSeq());
//			stmt.executeUpdate();
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			JDBCUtil.close(stmt, conn);
//		}
		
		System.out.println("===> Spring JDBC로 updateBoard() 기능 처리"); 
		getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
		
	}
	
	//글 삭제 
	public void deleteBoard(BoardVO vo){
//		System.out.println("===> JDBC로 deleteBoard() 기능 처리"); 
//		try{
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_DELETE);
//			stmt.setInt(1, vo.getSeq());
//			stmt.executeUpdate();
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			JDBCUtil.close(stmt, conn);
//		}
		
		System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리"); 
		getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
		
	}
	
	//글 상세 조회
	public BoardVO getBoard(BoardVO vo){
//		System.out.println("===> JDBC로 getBoard()기능 처리");
//		BoardVO board = null;
//		try{
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_GET);
//			stmt.setInt(1, vo.getSeq());
//			rs = stmt.executeQuery();
//			if(rs.next()){
//				board = new BoardVO();
//				board.setSeq(rs.getInt("SEQ"));
//				board.setTitle(rs.getString("TITLE"));
//				board.setWriter(rs.getString("WRITER"));
//				board.setContent(rs.getString("CONTENT"));
//				board.setRegDate(rs.getDate("REGDATE"));
//				board.setCnt(rs.getInt("CNT"));
//			}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			JDBCUtil.close(rs, stmt, conn);
//		}
//		return board;
		
		System.out.println("===> Spring JDBC로 getBoard()기능 처리");
		Object[] args = {vo.getSeq()};
		
		//queryForObject() : select 구문의 실행 결과를 특정 자바 객체(1개)로 매핑하여 리턴받을 때 사용.
		return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
		
		
	}
	
		//글 목록 조회
		public List<BoardVO> getBoardList(BoardVO vo){
//			System.out.println("===> JDBC로 getBoardList() 기능 처리");
//			List<BoardVO> BoardList = new ArrayList<BoardVO>();
//			try{
//				conn = JDBCUtil.getConnection();
//				stmt = conn.prepareStatement(BOARD_LIST);
//				rs = stmt.executeQuery();
//				while(rs.next()){
//					BoardVO board = new BoardVO();
//					board.setSeq(rs.getInt("SEQ"));
//					board.setTitle(rs.getString("TITLE"));
//					board.setWriter(rs.getString("WRITER"));
//					board.setContent(rs.getString("CONTENT"));
//					board.setRegDate(rs.getDate("REGDATE"));
//					board.setCnt(rs.getInt("CNT"));
//					BoardList.add(board);
//				}
//				
//			}catch(Exception e){
//				e.printStackTrace();
//			}finally{
//				JDBCUtil.close(rs, stmt, conn);
//			}
//			return BoardList;
			
			System.out.println("===> Spring JDBC로 getBoardList()기능 처리");
			//query() : select 구문의 실행 결과가 목록(여러개)일 때 사용.
			return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
		}
}
