package com.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.dao.mapper.BoardMapper;
import com.dev.domain.Board;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService
{
//	@Autowired
//	private BoardDAO dao;
//	
//	@Override
//	@Transactional(readOnly=true)
//	public List<Board> list() throws Exception
//	{
//		return dao.list();
//	}
//	
//	@Override
//	public Board read(Long boardNo) throws Exception
//	{
//		return dao.read(boardNo);
//	}
//	
//	@Override
//	@Transactional
//	public void register(Board board) throws Exception
//	{
//		dao.create(board);
//	}
//	
//	@Override
//	public void modify(Board board) throws Exception
//	{
//		dao.update(board);
//	}
//	
//	@Override
//	public void remove(Long boardNo) throws Exception
//	{
//		dao.delete(boardNo);
//	}
	@Autowired
	private final BoardMapper mapper;
	
	@Override
	public void register(Board board) throws Exception
	{
		mapper.create(board);
	}

	@Override
	public List<Board> list() throws Exception
	{
		return mapper.list();
	}
	
	@Override
	public Board read(Long boardNo) throws Exception
	{
		return mapper.read(boardNo);
	}
	
	@Override
	public void modify(Board board) throws Exception
	{
		mapper.update(board);
	}
	
	@Override
	public void remove(Long boardNo) throws Exception
	{
		mapper.delete(boardNo);
	}
}
