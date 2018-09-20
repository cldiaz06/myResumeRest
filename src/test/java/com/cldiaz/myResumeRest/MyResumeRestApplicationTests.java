package com.cldiaz.myResumeRest;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cldiaz.myResumeRest.models.BasicInfo;
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
			File map = new File(classLoader.getResource("json/basicInfo.json").getFile());
			
			ObjectMapper mapper = new ObjectMapper();
			
			BasicInfo basic = mapper.readValue(map, BasicInfo.class);
			
			System.out.println(basic.getTitle());
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
