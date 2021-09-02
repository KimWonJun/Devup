package com.dev.controller;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.domain.Card;
import com.dev.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MemberController 
{
	@PostMapping("/register01")
	public ResponseEntity<String> register01(@RequestBody Member member)
	{
		log.info("register01");
		
		log.info("userId = " + member.getUserId());
		log.info("password : " + member.getPassword());
		
		log.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	@PostMapping("/register02")
	public ResponseEntity<String> register02(@RequestBody Member member)
	{
		log.info("register02");
		
		log.info("userId = " + member.getUserId());
		log.info("password : " + member.getPassword());
		
		log.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	@PostMapping("/register03")
	public ResponseEntity<String> register03(@RequestBody Member member)
	{
		log.info("register03");
		
		log.info("userId = " + member.getUserId());
		log.info("password : " + member.getPassword());
		
		log.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	@PostMapping("/register04")
	public ResponseEntity<String> register04(@RequestBody Member member)
	{
		log.info("register04");
		
		log.info("userId = " + member.getUserId());
		log.info("password = " + member.getPassword());
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null)
		{
			log.info("cardList.size() = " + cardList.size());
			
			for(int i = 0; i < cardList.size(); i++)
			{
				Card card = cardList.get(i);
				log.info("card.getNo() = " + card.getNo());
				log.info("validMonth = " + card.getValidMonth());
			}
		}
		else
		{
			log.info("cardList == null");
		}
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	@GetMapping("/read")
	public ResponseEntity<Member> read()
	{
		log.info("register");
		
		Member member = new Member();
		member.setUserId("hongkd");
		member.setPassword("1234");
		
		Calendar cal = Calendar.getInstance();
		
		LocalDate dateOfBirth = LocalDate.of(1999,  5, 20);
		member.setDateOfBirth(dateOfBirth);
		
		member.setDateOfBirth(dateOfBirth);
		
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
}
