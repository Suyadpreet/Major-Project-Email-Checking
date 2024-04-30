package com.suyad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MajorProjectEmailCheckingApplication
{
	public static void main(String[] args) 
	{
		SpringApplication.run(MajorProjectEmailCheckingApplication.class, args);
		System.out.println("Mail Sender Checking has been started Successfully.....");
	}

}
