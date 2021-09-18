package com.dev.service;

import java.util.List;

import com.dev.domain.Board;

public interface BoardService 
{
	public List<Board> list() throws Exception;
	
	public void register(Board board) throws Exception;
}
