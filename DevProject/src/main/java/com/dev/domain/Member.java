package com.dev.domain;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member
{
	@NotBlank
	private String userId;
	@NotBlank
	private String password;
	@NotBlank
	@Size(max=3)
	private String userName;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	@Valid
	private Address address;
	
	@Valid
	private List<Card> cardList;
	
	public Member(String userId, String password)
	{
		super();
		this.userId = userId;
		this.password = password;
	}

	public Member() {
		// TODO Auto-generated constructor stub
	}
}
