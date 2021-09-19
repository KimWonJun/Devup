package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.dev.domain.Board;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BoardDAO 
{
	private final JdbcTemplate jdbcTemplate;
	
	public List<Board> list() throws Exception
	{
		List<Board> results = jdbcTemplate.query(
			"SELECT board_no, title, content, writer, reg_date FROM board WHERE board_no > 0 ORDER BY board_no desc, reg_date DESC",
			new RowMapper<Board>() 
			{
				@Override
				public Board mapRow(ResultSet rs, int rowNum) throws SQLException
				{
					Board board = new Board();
					
					board.setBoardNo(rs.getLong("board_no"));
					board.setTitle(rs.getString("title"));
					board.setContent(rs.getString("content"));
					board.setWriter(rs.getString("writer"));
					board.setRegDate(rs.getDate("reg_date"));
					
					return board;
				}
			});
		return results;
	}
	
	public Board read(Long boardNo) throws Exception
	{
		List<Board> results = jdbcTemplate.query(
			"SELECT board_no, title, content, writer, reg_date FROM board WHERE board_no = ?",
			new RowMapper<Board>()
			{
				@Override
				public Board mapRow(ResultSet rs, int rowNum) throws SQLException
				{
					Board board = new Board();
					
					board.setBoardNo(rs.getLong("board_no"));
					board.setTitle(rs.getString("title"));
					board.setContent(rs.getString("content"));
					board.setWriter(rs.getString("writer"));
					board.setRegDate(rs.getDate("reg_date"));
					
					return board;
				}
			}, boardNo);
		
		return results.isEmpty() ? null : results.get(0);		
	}
	
	public void create(Board board) throws Exception
	{
		String query = "INSERT INTO board (title, content, writer) VALUES (?, ?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
			new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException 
				{
					PreparedStatement ps = connection.prepareStatement(query, new String[] {"boardNo"});
					ps.setString(1,  board.getTitle());
					ps.setString(2, board.getContent());
					ps.setString(3,  board.getWriter());;
					return ps;
				}
			}, keyHolder);
		board.setBoardNo(keyHolder.getKey().longValue());
		
	}
	
	public void update(Board board) throws Exception
	{
		String query = "UPDATE board SET title=?, content=? WHERE board_no=?";
		jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getBoardNo());
	}
	
	public void delete(Long boardNo) throws Exception
	{
		String query = "DELETE FROM board WHERE board_no = ?";
		jdbcTemplate.update(query, boardNo);
	}
	
	
}
