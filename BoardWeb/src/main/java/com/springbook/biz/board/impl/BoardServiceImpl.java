package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;
	//private BoardDAOSpring boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		// 예외 발생 코드 추가 
		//if(vo.getSeq()==0){
		//	throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
		//}
		//트랜잭션 테스트. 똑같은 seq(키)값 insert시 에러(예외)발생.=>전부 rollback처리되어 모두 insert처리 안됨.
		boardDAO.insertBoard(vo);
		boardDAO.insertBoard(vo); 
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
