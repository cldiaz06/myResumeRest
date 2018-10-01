package com.cldiaz.myResumeRest.servicesImpl;

import java.io.File;
import java.util.List;

import com.cldiaz.myResumeRest.models.BasicInfo;
import com.cldiaz.myResumeRest.models.Education;
import com.cldiaz.myResumeRest.models.Experience;
import com.cldiaz.myResumeRest.models.Resume;
import com.cldiaz.myResumeRest.models.Skills;
import com.cldiaz.myResumeRest.services.GetResume;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


public class XmlGetResume implements GetResume {

	@Override
	public Resume getResume(Boolean debug) {
		try {
			
			ClassLoader classLoader = getClass().getClassLoader();
			File basicXml = new File(classLoader.getResource("xml/basicInfo.xml").getFile());
			File skillXml = new File(classLoader.getResource("xml/skills.xml").getFile());
			File educationXml = new File(classLoader.getResource("xml/education.xml").getFile());
			File experienceXml = new File(classLoader.getResource("xml/experience.xml").getFile());
			
			ObjectMapper mapper = new XmlMapper();
			
			BasicInfo basic = mapper.readValue(basicXml, BasicInfo.class);
			
			List<Skills> skill = mapper.readValue(skillXml, 
					mapper.getTypeFactory().constructCollectionType(List.class, Skills.class));
			
			List<Experience> exp = mapper.readValue(experienceXml, 
					mapper.getTypeFactory().constructCollectionType(List.class, Experience.class));
			
			List<Education>edu = mapper.readValue(educationXml, 
					mapper.getTypeFactory().constructCollectionType(List.class, Education.class));
			
			
			
			if (debug) {
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
			}
			
			return 
			
		}catch(Exception x) {
			x.printStackTrace();
			return null;
		} 
	}

}
