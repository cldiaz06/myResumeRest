package com.cldiaz.myResumeRest.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cldiaz.myResumeRest.config.ConfigProperties;

@Service
public class EmailServiceImpl {
	
	public EmailServiceImpl () {}
	
	@Autowired
	public JavaMailSender emailSender;
	
	private ConfigProperties prop;
	
	@Autowired
	public void setGlobalProperties(ConfigProperties prop) {
		this.prop = prop;
	}
	
	public void sendReferences(String emailAddress, String name, String companyName) throws MessagingException {
		
		MimeMessage message = emailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setTo(emailAddress);
		helper.setSubject("Chris Diaz References");
		helper.setText(setThanks(name, companyName));
		
		emailSender.send(message);
		
	}
	
	public String setThanks(String name, String company) {
		String result;	
		
		result = "To " + name + " of" + company + ", thank you request. Below are my professional references";
		
		return result;
	}
	
}
