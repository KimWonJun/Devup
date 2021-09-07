package com.dev.domain;

import java.time.YearMonth;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card 
{
	@NotBlank
	private String no;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Future
	private YearMonth validMonth;
}
