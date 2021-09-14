package com.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.domain.Board2;
import com.dev.service.Board2Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/board2")
public class Board2Controller 
{
	@Autowired
	private final Board2Service service;
	
	@GetMapping("/register")
	public void registerform(Board2 board, Model model) throws Exception
	{
		log.info("registerForm");
	}
	
	@PostMapping("/register")
	public String register(Board2 board, Model model) throws Exception
	{
		log.info("register");
		
		service.register(board);
		
		model.addAttribute("msg", "등록이 완료되었습니다.");
		
		return "board/success";
	}
	
	@GetMapping("/list")
	public void list(Model model) throws Exception
	{
		log.info("list");
		
		model.addAttribute("list", service.list());
	}
	
	@GetMapping("/read")
	public void read(int boardNo, Model model) throws Exception
	{
		log.info("read");
		
		model.addAttribute(service.read(boardNo));
	}
	
	@PostMapping("/remove")
	public String remove(int boardNo, Model model) throws Exception
	{
		log.info("read");
		
		service.remove(boardNo);
		
		model.addAttribute("msg", "삭제가 완료되었습니다");
		
		return "board/success";
	}
	
	@GetMapping("/modify")
	public void modifyForm(int boardNo, Model model) throws Exception
	{
		log.info("modifyForm");
		
		model.addAttribute(service.read(boardNo));
	}
	
	@PostMapping("/modify")
	public String modify(Board2 board, Model model) throws Exception 
	{
		log.info("modify");
		
		service.modify(board);
		
		model.addAttribute("msg", "수정이 완료되었습니다");
		
		return "board/success";
	}
	
	
}

