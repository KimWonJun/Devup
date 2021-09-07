package com.dev.controller;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	@PostMapping(value="/upload", produces = "text/plain; charset=UTF-8")
	public ResponseEntity<String> upload(MultipartFile file) throws Exception
	{
		String originalFilename = file.getOriginalFilename();
		
		log.info("originalName : " + originalFilename);
		
		ResponseEntity<String> entity = new ResponseEntity<String>("UPLOAD SUCCESS " + originalFilename, HttpStatus.OK);
		
		return entity;
	}
	
	@PostMapping(value="/users", produces="text/plain; charset=UTF-8")
	public ResponseEntity<String> register(@Validated @RequestBody Member member, BindingResult result)
	{
		log.info("reigster");
		
		log.info("result.hasErrors() = " + result.hasErrors());
		
		if(result.hasErrors())
		{
			List<ObjectError> allErrors = result.getAllErrors();
			List<ObjectError> globalErrors = result.getGlobalErrors();
			List<FieldError> fieldErrors = result.getFieldErrors();
			
			log.info("allErrors.size() = " + allErrors.size());
			log.info("globalError.size() = " + globalErrors.size());
			log.info("fieldError.size() = " + fieldErrors.size());
			
			for(int i = 0; i < allErrors.size(); i++)
			{
				ObjectError objectError = allErrors.get(i);
				log.info("allError = " + objectError);
			}
			
			for(int i = 0; i < globalErrors.size(); i++)
			{
				ObjectError objectError = globalErrors.get(i);
				log.info("globalError = " + objectError);
			}
			
			for(int i = 0; i < fieldErrors.size(); i++)
			{
				FieldError fieldError = fieldErrors.get(i);
				
				log.info("fieldError = " + fieldError);
				log.info("fieldError.getDefaultMessage() = " + fieldError.getDefaultMessage());
			}
			
			ResponseEntity<String> entity = new ResponseEntity<String>(result.toString(), HttpStatus.BAD_REQUEST);
			return entity;
		}
		
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getPassword() = " + member.getPassword());
		log.info("userName = " + member.getUserName());
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
}












