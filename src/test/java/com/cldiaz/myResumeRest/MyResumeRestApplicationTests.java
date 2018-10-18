package com.cldiaz.myResumeRest;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.cldiaz.myResumeRest.dataImport.JsonGetResume;
import com.cldiaz.myResumeRest.dataImport.XmlGetResume;
import com.cldiaz.myResumeRest.email.EmailServiceImpl;
import com.cldiaz.myResumeRest.models.Resume;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyResumeRestApplicationTests {

	@Test
	public void loadJson() {
		JsonGetResume resume = new JsonGetResume();
		
		Resume newResume = resume.getResume(true);
		
		System.out.println("******Json****");
		System.out.println(newResume.toString());
		System.out.println("******End Json****");
		
	}
	
	@Test
	public void loadXml() {
		XmlGetResume xml = new XmlGetResume();
		
		Resume res = xml.getResume(true);
		
		System.out.println("******XML****");
		System.out.println(res.toString());
		System.out.println("******End XML****");
	}
	
	@Test
	public void getHashPassword() {
		String password = "";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		System.out.println("hash Pass: ");
		System.out.println(hashedPassword);
	}

	@Test
	public void sendEmail() throws MessagingException {
		EmailServiceImpl email = new EmailServiceImpl();
		
		email.sendTextMail("cldiaz06@gmail.com", "Test spring email", "This email was sent from myResumeRest", 
				           "cldiaz1066.SpringResume@gmail.com", null);
	}
	
	
}
