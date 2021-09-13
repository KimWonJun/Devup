package com.dev.service;

import java.util.List;

import com.dev.domain.Board2;

public interface Board2Service 
{
	public void register(Board2 board) throws Exception;
	
	public Board2 read(Integer boardNo) throws Exception;
	
	public void modify(Board2 board) throws Exception;
	
	public void remove(Integer boardNo) throws Exception;
	
	public List<Board2> list() throws Exception;
}
