package com.cldiaz.myResumeRest.email;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.cldiaz.myResumeRest.config.ConfigProperties;

@Service
public class EmailServiceImpl{
	
	@Autowired
	public JavaMailSender javaMailSender;
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired 
	MailProperties mailProperties;
//	
//	@Value("${spring.mail.host}")
//	private String mailHost;
//	
//	@Value("${spring.mail.port}")
//	private String mailPort;
//	
//	@Value("${spring.mail.username}")
//	private String mailUserName;
//	
//	@Value("${spring.mail.password}")
//	private String mailPwd;
//	
//	@Value("${spring.mail.properties.mail.smtp.starttls.enable}")
//	private String mailEnableTLS;
//	
//	@Value("${spring.mail.properties.mail.smtp.starttls.required}")
//	private String mailRequireTLS;
//	
//	@Value("${spring.mail.properties.mail.smtp.auth}")
//	private String mailAuth;
	
	
	public EmailServiceImpl () {
		
//		mailProperties.setHost(mailHost);
//		mailProperties.setPort(Integer.parseInt(mailPort));
//		mailProperties.setUsername(mailUserName);
//		mailProperties.setPassword(mailPwd);
		
	}
	
	@Async
	public void sendTextMail(String to, String subject, String body, String cc, String bcc
			)throws MessagingException{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setText(body);
		message.setSubject(subject);
		if(cc!=null) message.setCc(cc);
		if(bcc!=null) message.setBcc(bcc);
		javaMailSender.send(message);
	}
	
	@Async
	public void sendHtmlMail(String to, String subject, String templateName, Context context
			) throws MessagingException{
		MimeMessage mail = javaMailSender.createMimeMessage();
		String body = templateEngine.process(templateName, context);
		MimeMessageHelper helper = new MimeMessageHelper(mail, true);
		try {
			helper.setFrom(
				mailProperties.getProperties().get("from"),
				mailProperties.getProperties().get("personal"));
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, true);
		javaMailSender.send(mail);
	}
	
	
	
}
