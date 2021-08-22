package com.dev.domain;

import java.time.YearMonth;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card 
{
	private String no;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private YearMonth validMonth;
}
