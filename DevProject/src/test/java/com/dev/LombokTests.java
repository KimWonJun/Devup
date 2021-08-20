package com.dev;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.dev.domain.Board;
import com.dev.domain.Member;
import com.dev.domain.Student;
import com.dev.domain.UserItem;

public class LombokTests {

	public void testNoArgsConstructor()
	{
		Board board = new Board();
		System.out.println(board);
	}
	
//	public void testRequiredArgsConstructor()
//	{
//		Board board = new Board("테스트 제목");
//		System.out.println(board);
//	}

	public void testGetter()
	{
		Board board = new Board();
		
		System.out.println(board.getTitle());
	}

	public void testSetter()
	{
		Board board = new Board();
		board.setTitle("게시판제목");
		
		System.out.println(board.getTitle());
	}

	public void testToString()
	{
		Board board = new Board();
		System.out.println(board);
	}
	
//	public void testToStringExclude()
//	{
//		Member member = new Member();
//		System.out.println(member);
//	}
	
	public void testboard()
	{
		Board board1 = new Board();
		board1.setBoardNo(1);;
		board1.setTitle("title1");
		
		Board board2 = new Board();
		board2.setBoardNo(2);
		board2.setTitle("title2");
		
		Board board3 = new Board();
		board3.setBoardNo(3);
		board3.setTitle("title3");
		
		Set<Board> boardSet = new HashSet<Board>();
		
		boardSet.add(board1);
		boardSet.add(board2);
		boardSet.add(board3);
		
		System.out.println("저장된 데이터 수 : " + boardSet.size());
		
		Iterator<Board> it = boardSet.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	
	public void testUserItem()
	{
		UserItem userItem1 = new UserItem();
		userItem1.setUserNo(1);
		userItem1.setItemId(100);
		userItem1.setDescription("userItem1");
		
		UserItem userItem2 = new UserItem();
		userItem2.setUserNo(2);
		userItem2.setItemId(200);
		userItem2.setDescription("userItem2");
		
		UserItem userItem3 = new UserItem();
		userItem3.setUserNo(3);
		userItem3.setItemId(300);
		userItem3.setDescription("userItem3");
		
		Set<UserItem> userItemSet = new HashSet<UserItem>();
		
		userItemSet.add(userItem1);
		userItemSet.add(userItem2);
		userItemSet.add(userItem3);
		
		System.out.println("저장된 데이터 수 : " + userItemSet.size());
		
		Iterator<UserItem> it = userItemSet.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	
	public void testStudent()
	{
		Student student1 = new Student();
		student1.setStudentNo(1);
		student1.setName("Alex");
		
		Student student2 = new Student();
		student2.setStudentNo(2);
		student2.setName("Alex");
		
		Set<Student> studentSet = new HashSet<Student>();
		
		studentSet.add(student1);
		studentSet.add(student2);
		
		System.out.println("저장된 데이터 수 : " + studentSet.size());
		
		Iterator<Student> it = studentSet.iterator();
		while(it.hasNext()) 
		{
			System.out.println(it.next());
		}
	}
	
//	public void testNoArgsConstructor2()
//	{
//		Member member = new Member();
//		
//		System.out.println(member);
//	}
	
	public void testRequiredArgsConstructor()
	{
		Board board = new Board(1);
		System.out.println(board);
	}
	
	public void testRequiredArgsConstructor2()
	{
		Member member = new Member("userId1", "password");
		System.out.println(member);
	}
	
	public void testAllArgsConstructor()
	{
		Board board = new Board(1, "title1", "content1", "writer1", LocalDateTime.now());
		System.out.println(board);
	}
	
//	public void testAllArgsConstructor2()
//	{
//		Member member = new Member("userId1", "password1", "userName1");
//		System.out.println(member);
//	}
	
	@Test
	public void testBoardBuilder()
	{
		Board board = Board.builder()
				.boardNo(1)
				.title("title")
				.content("content1")
				.writer("writer")
				.regDate(LocalDateTime.now())
				.build();
		System.out.println(board);
	}
	
//	@Test
//	public void testMemberBuilder()
//	{
//		Member member = Member.builder()
//				.userId("userId1")
//				.password("password1");
//				.build();
//	}
}




























