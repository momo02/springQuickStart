package com.springbook.biz.board;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity//엔티티 클래스. @Entity를 붙이면 JPA가 이 클래스를 엔티티 클래스로 인식하여 관련된 테이블과 자동으로 매핑 처리.
@Table(name = "BOARD")//엔티티와 관련된 테이블을 매핑. name속성 생략 시 클래스 이름과 같은 이름의 테이블이 자동으로 매핑.
public class Board{
	@Id //엔티티 클래스의 필수 어노테이션. 특정 변수를 테이블의 기본키와 매핑. @Id가 없는 엔티티 클래스는 JPA가 처리하지 못함.
	@GeneratedValue //@Id가 선언된 필드에 기본 키를 자동으로 생성하여 할당. @GeneratedValue만 사용하면 데이터베이스에 따라서 자동으로 결정.
	private int seq; 
	
	private String title;
	private String writer;
	private String content;
	
	@Temporal(TemporalType.DATE) //날짜 타입의 변수에 선언하여 날짜 타입을 매핑할 때 사용.(DATE,TIME,TIMESTAMP 중 하나 선택)
	private Date regDate = new Date();
	
	private int cnt;
	
	//=> 매핑 정보가 없는 나머지 필드들은 자동으로 BOARD테이블의 동일한 칼럼과 매핑.
	
	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public int getCnt() {
		return cnt;
	}


	public void setCnt(int cnt) {
		this.cnt = cnt;
	}


	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + "]";
	}
   
	
	
}
