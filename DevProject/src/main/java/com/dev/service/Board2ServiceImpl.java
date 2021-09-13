package com.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.Board2DAO;
import com.dev.domain.Board2;

@Service
public class Board2ServiceImpl implements Board2Service 
{
	@Autowired
	private Board2DAO dao;
	
	@Override
	public void register(Board2 board) throws Exception 
	{
		dao.create(board);
	}

	@Override
	public Board2 read(Integer boardNo) throws Exception 
	{
		return dao.read(boardNo);
	}

	@Override
	public void modify(Board2 board) throws Exception 
	{
		dao.update(board);
	}

	@Override
	public void remove(Integer boardNo) throws Exception 
	{
		dao.delete(boardNo);
	}

	@Override
	public List<Board2> list() throws Exception 
	{
		return dao.list();
	}
	
}
