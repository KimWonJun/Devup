package com.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.domain.Board;
import com.dev.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/boards")
public class BoardController
{
	@Autowired
	private BoardService service;
	
	@GetMapping("")
	public ResponseEntity<List<Board>> list() throws Exception
	{
		log.info("list");
		
		return new ResponseEntity<>(service.list(), HttpStatus.OK);
	}
	
	@GetMapping("/{boardNo}")
	public ResponseEntity<Board> read(@PathVariable("boardNo") Long boardNo) throws Exception
	{
		log.info("read");
		
		Board board = service.read(boardNo);
		
		return new ResponseEntity<>(board, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Board> register(@Validated @RequestBody Board board) throws Exception
	{
		log.info("register");
		
		service.register(board);
		
		log.info("register board.getBoardNo() = " + board.getBoardNo());
		
		return new ResponseEntity<>(board, HttpStatus.OK);
	}
	
	@PutMapping("/{boardNo}")
	public ResponseEntity<Void> modify(@PathVariable("boardNo") Long boardNo, @Validated @RequestBody Board board) throws Exception
	{
		log.info("modify");
		
		board.setBoardNo(boardNo);
		service.modify(board);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{boardNo}")
	public ResponseEntity<Void> remove(@PathVariable("boardNo") Long boardNo) throws Exception
	{
		log.info("remove");
		
		service.remove(boardNo);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
