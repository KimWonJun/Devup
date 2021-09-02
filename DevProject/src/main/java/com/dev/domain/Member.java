package com.dev.domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member
{
	private String userId;
	private String password;
	private String userName;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	private Address address;
	private List<Card> cardList;
	
	public Member(String userId, String password)
	{
		super();
		this.userId = userId;
		this.password = password;
	}
}
