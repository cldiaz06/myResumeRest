package com.cldiaz.myResumeRest.emailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cldiaz.myResumeRest.interfaces.SendEmailService;

@Service("testSendingEmail")
public class testSendingEmail implements SendEmailService {
	
	@Autowired
	private JavaMailSender sender;
	
	@Override
	public void sendEmail() throws Exception {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo("cldiaz06@gmail.com");
		helper.setText("Test sending email from spring boot service");
		helper.setSubject("from myResumeRest");
		
		sender.send(message);
	}

}
