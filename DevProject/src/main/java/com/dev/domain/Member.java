package com.dev.domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
public class Member
{
	private final String userId;
	private final String password;
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
