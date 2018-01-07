package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

//DAO(Data Access Object)
// 정상적인 <bean>등록으로 객체를 생성할 예정이므로 어노테이션은 설정하지 않는다.
public class UserDAO {
	//JDBC 관련 변수
		private Connection conn = null;
		private PreparedStatement stmt = null;
		private ResultSet rs = null;
		
		//SQL 명령어들
		private final String USER_GET = "select * from users where id=? and password=?";
		
		//CRUD 기능의 메소드 구현
		//회원 등록
		public UserVO getUser(UserVO vo){
			UserVO user = null;
			try{
				System.out.println("===> JDBC로 getUser() 기능 처리"); 
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(USER_GET);
				stmt.setString(1, vo.getId()); //index 1부터.
				stmt.setString(2, vo.getPassword());
				rs = stmt.executeQuery(); //쿼리 실행
				
				if(rs.next()){
					user = new UserVO();
					user.setId(rs.getString("ID"));
					user.setPassword(rs.getString("PASSWORD"));
					user.setName(rs.getString("NAME"));
					user.setRole(rs.getString("ROLE"));
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				JDBCUtil.close(rs, stmt, conn);
			}
			return user;
		}
}
