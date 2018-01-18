package com.springbook.biz.board.impl;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springbook.biz.board.BoardVO;

public class BoardRowMapper implements RowMapper<BoardVO> {

	//스프링 컨테이너가 sql문 수행후 자동으로 RowMapper객체의 mapRow()메서드 호출.
	//검색 결과로 얻어낸 Row정보를 어떤 VO에 어떻게 매핑할 것인지를 구현.
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriter(rs.getString("WRITER"));
		board.setContent(rs.getString("CONTENT"));
		board.setCnt(rs.getInt("CNT"));
		return board;
	}

}
