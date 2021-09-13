package com.dev;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.domain.Board;
import com.dev.domain.Board2;

@Repository
public class Board2DAO 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void create(Board2 board) throws Exception 
	{
		String query = "INSERT INTO board (title, content, writer) VALUES(?, ?, ?)";
		jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter());
	}
	
	public Board2 read(Integer boardNo) throws Exception
	{
		List<Board> results = jdbcTemplate.query(
			"SELECT board_no, title, content, writer, reg_date FROM board WHERE board_no = ?",
			new RowMapper<Board2>() 
			{
				@Override
				public Board2 mapRow(ResultSet rs, int rowNum) throws SQLException
				{
					Board2 board = new Board2();
					
					board.setBoardNo(rs.getInt("board_no"));
					board.setTitle(rs.getString("title"));
					board.setContent(rs.getString("content"));
					board.setWriter(rs.getString("writer"));
					
					Timestamp timestamp = rs.getTimestamp("reg_date");
					board.setRegDate(timestamp.toLocalDateTime());
					
					return board;
				}
			}, boardNo);
			
		return results.isEmpty() ? null : results.get(0);
	}
	
	public void update(Board2 board) throws Exception 
	{
		String query = "UPDATE board SET title = ?, content = ? WHERE board_no = ?";
		jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getBoardNo());
	}
	
	public void delete(Integer boardNo) throws Exception
	{
		String query = "delete from board where board_no=?";
		jdbcTemplate.update(query, boardNo);
	}
	
	public List<Board2> list() throws Exception
	{
		List<Board2> results = jdbcTemplate.query(
			"SELECT board_no, title, content, writer, reg_date "
			+ "FROM board WHERE board_no > 0 ORDER BY board_no desc, reg_date DESC",
			new RowMapper<Board2>() 
			{
				@Override
				public Board2 mapRow(ResultSet rs, int rowNum) throws SQLException
				{
					Board2 board = new Board2();
					
					board.setBoardNo(rs, getInt("board_no"));
					board.setTitle(rs.getString("title"));
					board.setContent(rs.getString("content"));
					board.setWriter(rs.getString("writer"));
					
					TimeStamp timestamp = rs.getTimestamp("reg_date");
					board.setRegDate(timestamp.toLocalDateTime());
					
					return board;
				}
			});
		
		return results;
	}
}



















