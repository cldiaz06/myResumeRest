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
import com.cldiaz.myResumeRest.models.Skills;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyResumeRestApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void loadJson() {
		try {
			//String map = "/resouces/json/basicInfo.json";
			
			ClassLoader classLoader = getClass().getClassLoader();
			File basicJson = new File(classLoader.getResource("json/basicInfo.json").getFile());
			File skillJson = new File(classLoader.getResource("json/skills.json").getFile());
			File educationJson = new File(classLoader.getResource("json/education.json").getFile());
			File experienceJson = new File(classLoader.getResource("json/experience.json").getFile());
			
			ObjectMapper mapper = new ObjectMapper();
			
			BasicInfo basic = mapper.readValue(basicJson, BasicInfo.class);
		
			List<Skills> skill = mapper.readValue(skillJson, 
					mapper.getTypeFactory().constructCollectionType(List.class, Skills.class));
			List<Experience> exp = mapper.readValue(educationJson, 
					mapper.getTypeFactory().constructCollectionType(List.class, Experience.class));
			
			List<Education>edu = mapper.readValue(educationJson, 
					mapper.getTypeFactory().constructCollectionType(List.class, Education.class));

			System.out.println("***Basicinfo*****");
			System.out.println(basic.toString());
			
			System.out.println("***Skills*****");
			for(Skills temp :skill) {
				System.out.println(temp.toString());
			}
			
			System.out.println("***Experience*****");
			for(Experience temp :exp) {
				System.out.println(temp.toString());
			}
			
			System.out.println("***Education*****");
			for(Education temp :edu) {
				System.out.println(temp.toString());
			}
			
			
			
		
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
