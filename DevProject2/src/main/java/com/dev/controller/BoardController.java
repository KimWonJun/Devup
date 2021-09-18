package com.dev.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.dev.domain.Board;
import com.dev.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("/boards")
public class BoardController
{
	@Autowired
	private BoardService service;
	
	@GetMapping
	public ResponseEntity<List<Board>> list() throws Exception
	{
		log.info("list");
		
		return new ResponseEntity<>(service.list(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> register(@Validated @RequestBody Board board, UriComponentsBuilder uriBuilder) throws Exception
	{
		log.info("register");
		
		service.register(board);
		
		log.info("register board.getBoardNo() = " + board.getBoardNo());
		
		URI resourceUri = uriBuilder.path("boards/{boardNo}")
				.buildAndExpand(board.getBoardNo())
				.encode()
				.toUri();
		
		return ResponseEntity.created(resourceUri).build();
	}
}
