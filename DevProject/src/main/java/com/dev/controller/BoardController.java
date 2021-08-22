package com.dev.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.dev.domain.Member;

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
	
	@GetMapping("/register02")
	public String register02()
	{
		log.info("register02");
		return "HELLO";
	}
	
	@GetMapping("/register03")
	public Member register03()
	{
		log.info("register03");
		
		Member member = new Member("hongkd", "1234");
		return member;
	}
	
	@GetMapping("/register04")
	public List<Member> register04()
	{
		log.info("register04");
		
		List<Member> list = new ArrayList<Member>();
		
		Member member = new Member("유저1", "1125");
		list.add(member);
		
		Member member2 = new Member("유저2", "2234");
		list.add(member2);
		
		return list;
	}
	
	@GetMapping("/register05")
	public Map<String, Member> register05()
	{
		log.info("register05");
		
		Map<String, Member> map = new HashMap<String, Member>();
		
		Member member1 = new Member("유저1", "1125");
		map.put("key1", member1);
		
		Member member2 = new Member("유저2", "1532");
		map.put("key2", member2);
		
		return map;
	}
	
	@GetMapping("/register06")
	public ResponseEntity<Void> register06()
	{
		log.info("register06");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/register07")
	public ResponseEntity<String> register07()
	{
		log.info("register07");
		return new ResponseEntity<String>("HELLO", HttpStatus.OK);
	}
	
	@GetMapping("/register08")
	public ResponseEntity<Member> register08()
	{
		log.info("register08");
		Member member = new Member("유저3", "3333");
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@GetMapping("/register09")
	public ResponseEntity<List<Member>> register09()
	{
		log.info("register09");

		List<Member> list = new ArrayList<Member>();
		
		Member member1 = new Member("유저1", "1125");
		list.add(member1);
		
		Member member2 = new Member("유저2", "1532");
		list.add(member2);
		
		return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/register10")
	public ResponseEntity<Map<String, Member>> register10()
	{
		log.info("register10");

		Map<String, Member> map = new HashMap<String, Member>();
		
		Member member1 = new Member("유저1", "1125");
		map.put("key1", member1);
		
		Member member2 = new Member("유저2", "1532");
		map.put("key2", member2);
		
		return new ResponseEntity<Map<String, Member>>(map, HttpStatus.OK);
	}
	
	@GetMapping("/register11")
	public ResponseEntity<byte[]> register11() throws Exception
	{
		log.info("register11");
		
		String fileName = "data.zip";
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		try
		{
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream("C:\\TEMP\\" + fileName);
			
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition",  "attachment; filename=\""+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		finally {
			in.close();
		}
		return entity;
	}
}













































