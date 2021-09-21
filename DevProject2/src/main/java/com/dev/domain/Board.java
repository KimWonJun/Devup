package com.dev.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

@ToString
public class Board 
{
	private Long boardNo;
	
	private String title;
	
	private String content;
	
	private String writer;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date regDate;
	
	public Long getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(Long boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
}
