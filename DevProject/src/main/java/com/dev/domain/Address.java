package com.dev.domain;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address 
{
	@NotBlank
	private String postCode;
	@NotBlank
	private String location;
	
}
