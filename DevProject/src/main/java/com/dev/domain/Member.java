package com.dev.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@Builder
public class Member
{
	private final String userId;
	private final String password;
	private String userName;
	
	public Member(String userId, String password)
	{
		super();
		this.userId = userId;
		this.password = password;
	}
}
