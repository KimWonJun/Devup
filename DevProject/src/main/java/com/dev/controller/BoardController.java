package com.dev.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.domain.Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/boards")
public class BoardController 
{
//	@GetMapping
//	public ResponseEntity<List<Board>> list()
//	{
//		log.info("list");
//		
//		List<Board> boardList = new ArrayList<>();
//		
//		Board board = new Board();
//		board.setBoardNo(1);
//		board.setTitle("향수");
//		board.setContent("넓은 벌 동쪽 끝으로");
//		board.setWriter("hongkd");
//		board.setRegDate(LocalDateTime.now());
//		
//		boardList.add(board);
//		
//		board = new Board();
//		board.setBoardNo(2);
//		board.setTitle("첫 마음");
//		board.setContent("날마다 새로우며 깊어지고 넓어진다");
//		board.setWriter("hongkd");
//		board.setRegDate(LocalDateTime.now());
//		
//		boardList.add(board);
//		
//		ResponseEntity<List<Board>> entity = new ResponseEntity<>(boardList, HttpStatus.OK);
//		
//		return entity;
//	}
	
	@PostMapping
	public ResponseEntity<String> register(@RequestBody Board board)
	{
		log.info("register");
		
		log.info("Title : " + board.getTitle());
		log.info("Content : " + board.getContent());
		log.info("writer : " + board.getWriter());
		
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
//	@GetMapping("/{boardNo}")
//	public ResponseEntity<Board> read(@PathVariable("boardNo") int boardNo)
//	{
//		log.info("read");
//		
//		Board board = new Board();
//		board.setBoardNo(1);
//		board.setTitle("향수");
//		board.setContent("넓은 벌 동쪽 끝으로");
//		board.setWriter("hongkd");
//		board.setRegDate(LocalDateTime.now());
//		
//		ResponseEntity<Board> entity = new ResponseEntity<>(board, HttpStatus.OK);
//		
//		return entity;
//	}
	
	@DeleteMapping("/{boardNo}")
	public ResponseEntity<String> remove(@PathVariable("boardNo") int boardNo)
	{
		log.info("remove");
		
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
//	@PutMapping("/{boardNo}")
//	public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo, @RequestBody Board board)
//	{
//		log.info("modify");
//		
//		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
//		
//		return entity;
//	}
	
	@RequestMapping("/register")
	public void registerForm()
	{
		log.info("registerForm");
	}
	
	@RequestMapping("/modify")
	public void modifyForm()
	{
		log.info("modifyForm");
	}
	
	@RequestMapping("/list")
	public String list()
	{
		log.info("list");
		return "LIST";
	}
	
	@GetMapping("/read/{boardNo}")
	public String read(@PathVariable int boardNo)
	{
		log.info("read boardNo : " + boardNo);
		return "READ boardNo : " + boardNo;
	}
	
	@GetMapping("/read2/{no}")
	public String read2(@PathVariable("no") int boardNo)
	{
		log.info("read2 boardNo : " + boardNo);
		return "READ2 boardNo : " + boardNo;
	}
	
//	@GetMapping("/{boardNo}")
//	public ResponseEntity<Board> readBoard(@PathVariable("boardNo") int boardNo)
//	{
//		log.info("read");
//		
//		Board board = new Board();
//		ResponseEntity<Board> entity = new ResponseEntity<>(board, HttpStatus.OK);
//		return entity;
//	}
	
	@PatchMapping("/{boardNo}")
	public ResponseEntity<String> modifyByPatch(@PathVariable("boardNo") int boardNo, @RequestBody Board board)
	{
		log.info("modifyByPatch");
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
//	@PutMapping("/{boardNo}")
//	public ResponseEntity<String> modifyByHeader(@PathVariable("boardNo") int boardNo, @RequestBody Board board)
//	{
//		log.info("modifyByHeader");
//		
//		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//		return entity;
//	}
	
	@PutMapping(value = "/{boardNo}", consumes="application/xml")
	public ResponseEntity<String> modifyByXml(@PathVariable("boardNo") int boardNo, @RequestBody Board board)
	{
		log.info("modifyByXml");
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	@GetMapping(value="/{boardNo}", produces="application/json")
	public ResponseEntity<Board> readToJson(@PathVariable("boardNo") int boardNo)
	{
		log.info("readToJson");
		
		Board board = new Board();
		board.setTitle("제목");
		board.setContent("내용입니다?");
		board.setWriter("홍길동");
		board.setRegDate(LocalDateTime.now());
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board, HttpStatus.OK);
		return entity;
	}
	
	@GetMapping("/register01")
	public void register01()
	{
		log.info("register01");
	}
}













































