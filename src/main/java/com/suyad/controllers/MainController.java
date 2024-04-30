package com.suyad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.internet.MimeMessage;

@RestController
public class MainController
{
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/wel")
	public String getWel()
	{
		return "Welcome to Our Application";
	}
	@GetMapping("/idx")
	public String getidx()
	{
		try
		{
			Integer myid = 10;
			String myname = "Suyadpreet Singh";
			MimeMessage msg = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg,true);// use true to Send Multipart(attached,files) with mail
			helper.setTo("suyadpreet@gmail.com");
			helper.setSubject("Your Report");
			helper.setText("<h2>Please download your report Mr. "+myname+
					"</h2><br><p><a href=http://localhost:8081/wel?id="+myid+"&name="+myname+">To visit Welcome Page click here</a></p>", true);
			//helper.addAttachment(file.getName(), file);
			mailSender.send(msg);
			//status = true;
			return "Mail has been send successfully....";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Mail Error Occured";
		}
		
	}
}
