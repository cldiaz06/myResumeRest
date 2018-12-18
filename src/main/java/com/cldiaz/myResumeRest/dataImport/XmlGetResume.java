package com.cldiaz.myResumeRest.dataImport;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cldiaz.myResumeRest.interfaces.GetResume;
import com.cldiaz.myResumeRest.models.BasicInfo;
import com.cldiaz.myResumeRest.models.Education;
import com.cldiaz.myResumeRest.models.Experience;
import com.cldiaz.myResumeRest.models.Interests;
import com.cldiaz.myResumeRest.models.Resume;
import com.cldiaz.myResumeRest.models.Skill_Years;
import com.cldiaz.myResumeRest.models.Skills;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Service("xmlGetResume")
public class XmlGetResume implements GetResume {

	@Override
	public Resume getResume(Boolean debug) {
		try {
			
			ClassLoader classLoader = getClass().getClassLoader();
			File basicXml = new File(classLoader.getResource("xml/basicInfo.xml").getFile());
			File skillXml = new File(classLoader.getResource("xml/skills.xml").getFile());
			File educationXml = new File(classLoader.getResource("xml/education.xml").getFile());
			File experienceXml = new File(classLoader.getResource("xml/experience.xml").getFile());
			File yearsXml = new File(classLoader.getResource("xml/skill_years.xml").getFile());
			File interestXml = new File(classLoader.getResource("xml/interests.xml").getFile());
			
			ObjectMapper mapper = new XmlMapper();
			
			BasicInfo basic = mapper.readValue(basicXml, BasicInfo.class);
			
			List<Skills> skill = mapper.readValue(skillXml, 
					mapper.getTypeFactory().constructCollectionType(List.class, Skills.class));
			
			List<Experience> exp = mapper.readValue(experienceXml, 
					mapper.getTypeFactory().constructCollectionType(List.class, Experience.class));
			
			List<Education>edu = mapper.readValue(educationXml, 
					mapper.getTypeFactory().constructCollectionType(List.class, Education.class));
			
			List<Skill_Years>years = mapper.readValue(yearsXml, 
					mapper.getTypeFactory().constructCollectionType(List.class, Skill_Years.class));
			
			List<Interests>inter = mapper.readValue(interestXml, 
					mapper.getTypeFactory().constructCollectionType(List.class, Interests.class));
			
			
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
				
				System.out.println("***Skill years*****");
				for(Skill_Years temp :years) {
					System.out.println(temp.toString());
				}
				
				System.out.println("***Interests*****");
				for(Interests temp :inter) {
					System.out.println(temp.toString());
				}
			}
			
			return new Resume(basic, skill, exp, edu, years,inter);
			
		}catch(Exception x) {
			x.printStackTrace();
			return null;
		} 
	}

}
