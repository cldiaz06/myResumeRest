package com.cldiaz.myResumeRest;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cldiaz.myResumeRest.models.BasicInfo;
import com.cldiaz.myResumeRest.models.Education;
import com.cldiaz.myResumeRest.models.Experience;
import com.cldiaz.myResumeRest.models.Resume;
import com.cldiaz.myResumeRest.models.Skills;
import com.cldiaz.myResumeRest.servicesImpl.JsonGetResume;
import com.cldiaz.myResumeRest.servicesImpl.XmlGetResume;
import com.fasterxml.jackson.databind.ObjectMapper;


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
