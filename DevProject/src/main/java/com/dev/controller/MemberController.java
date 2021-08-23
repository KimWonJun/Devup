package com.dev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/register")
public class MemberController 
{
	@PostMapping("/{userId}/{password}")
	public ResponseEntity<String> register02(@PathVariable("userId") String userId, @PathVariable("password") String password)
	{
		log.info("register02");
		
		log.info("userId = " + userId);
		log.info("password : " + password);
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
}
