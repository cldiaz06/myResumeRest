package com.cldiaz.myResumeRest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.cldiaz.myResumeRest.dataImport.JsonGetResume;
import com.cldiaz.myResumeRest.dataImport.XmlGetResume;
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
	
//	@Test
//	public void getHashPassword() {
////		String password = "";
////		if (!password.isEmpty()) {
////			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
////			String hashedPassword = passwordEncoder.encode(password);
////			System.out.println("hash Pass: ");
////			System.out.println(hashedPassword);
//		}
//	}
	
}
