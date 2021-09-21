package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.dev.Board"})
public class DevProject2Application
{
	public static void main(String[] args) 
	{
		SpringApplication.run(DevProject2Application.class, args);
	}

}
