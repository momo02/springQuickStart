package com.springbook.biz.board;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="boardList") //XML의 루트 엘리먼트에 해당하는 객체이며,루트 엘리먼트 이름을 boardList로 설정하겠다는 의미 
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardListVO {
	@XmlElement(name="board") //element이름을 "board"로 변경. 이 설정이 없으면 변수이름인 "boardList"가 엘리먼트 이름으로 사용됨.
	private List<BoardVO> boardList;

	public List<BoardVO> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}
	
	
}
