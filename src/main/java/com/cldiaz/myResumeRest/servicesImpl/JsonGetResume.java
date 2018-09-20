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

public class JsonGetResume implements GetResume {

	@Override
	public Resume getResume() {
		// TODO Auto-generated method stub
		try {
		
			ClassLoader classLoader = getClass().getClassLoader();
			File basicJson = new File(classLoader.getResource("json/basicInfo.json").getFile());
			File skillJson = new File(classLoader.getResource("json/skills.json").getFile());
			File educationJson = new File(classLoader.getResource("json/education.json").getFile());
			File experienceJson = new File(classLoader.getResource("json/experience.json").getFile());
			
			ObjectMapper mapper = new ObjectMapper();
			
			BasicInfo basic = mapper.readValue(basicJson, BasicInfo.class);
		
			List<Skills> skill = mapper.readValue(skillJson, 
					mapper.getTypeFactory().constructCollectionType(List.class, Skills.class));
			
			List<Experience> exp = mapper.readValue(experienceJson, 
					mapper.getTypeFactory().constructCollectionType(List.class, Experience.class));
			
			List<Education>edu = mapper.readValue(educationJson, 
					mapper.getTypeFactory().constructCollectionType(List.class, Education.class));

			return new Resume(basic, skill, exp, edu, "default");
		
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		} 
		
	}

}
