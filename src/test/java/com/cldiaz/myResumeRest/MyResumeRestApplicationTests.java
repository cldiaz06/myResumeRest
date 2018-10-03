package com.cldiaz.myResumeRest;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cldiaz.myResumeRest.models.Resume;
import com.cldiaz.myResumeRest.servicesImpl.EmailServiceImpl;
import com.cldiaz.myResumeRest.servicesImpl.JsonGetResume;
import com.cldiaz.myResumeRest.servicesImpl.XmlGetResume;


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

	
	
}
