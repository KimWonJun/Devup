package com.dev.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@RequiredArgsConstructor
@Builder
public class Board implements java.io.Serializable
{
//	private static final long serialVersionUID = 1L;

	@NonNull
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate;
	
//	public Board()
//	{
//		super();
//	}
//	
//	public Board(int boardNo, String title)
//	{
//		super();
//		this.boardNo = boardNo;
//		this.title = title;
//	}
//
//	public int getBoardNo() {
//		return boardNo;
//	}
//
//	public void setBoardNo(int boardNo) {
//		this.boardNo = boardNo;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public String getWriter() {
//		return writer;
//	}
//
//	public void setWriter(String writer) {
//		this.writer = writer;
//	}
//
//	public LocalDateTime getRegDate() {
//		return regDate;
//	}
//
//	public void setRegDate(LocalDateTime regDate) {
//		this.regDate = regDate;
//	}
//	
//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + boardNo;
//		return result;
//	}
//	
//	public boolean equals(Object obj)
//	{
//		if(this == obj)
//			return true;
//		if(obj == null)
//			return false;
//		if(getClass() != obj.getClass())
//			return false;
//		Board other = (Board) obj;
//		if(boardNo != other.boardNo)
//			return false;
//		return true;
//	}
//	
//	public String toString()
//	{
//		return "Board(boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regDate=" + regDate + ")";
//	}
}















