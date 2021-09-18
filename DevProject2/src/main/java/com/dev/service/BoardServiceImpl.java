package com.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.domain.Board;
import com.dev.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService
{
	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Board> list() throws Exception
	{
		return boardRepository.findAll(Sort.by(Direction.DESC, "boardNO"));
	}
	
	@Override
	@Transactional
	public void register(Board board) throws Exception
	{
		boardRepository.save(board);
	}
}
