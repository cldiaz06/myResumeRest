package com.cldiaz.myResumeRest.dataImport;

import java.util.ArrayList;

import com.cldiaz.myResumeRest.interfaces.GetResume;
import com.cldiaz.myResumeRest.models.BasicInfo;
import com.cldiaz.myResumeRest.models.Education;
import com.cldiaz.myResumeRest.models.Experience;
import com.cldiaz.myResumeRest.models.Resume;
import com.cldiaz.myResumeRest.models.Skill_Years;
import com.cldiaz.myResumeRest.models.Skills;

public class JavaCodeGetResume implements GetResume {

	@Override
	public Resume getResume(Boolean debug) {
		BasicInfo basic = new BasicInfo();
		basic.setFirstName("Christopher");
		basic.setLastName("Diaz");
		basic.setCity("Oak Park");
		basic.setState("IL");
		basic.setPostalcode("60301");
		basic.setPhone("773-732-4404");
		basic.setEmail("cldiaz1066@yahoo.com");
		basic.setGit_url("git@gitlab.com");
		
		ArrayList<Skills> skill = new ArrayList<>();
		skill.add(new Skills("Languages: ", "TSql, Delphi, Java, C#, Python, ASP,Html, Javascript, XML, JSON"));
		skill.add(new Skills("Frameworks: ", "Spring MVC & Boot, ASP.net 4.0: MVC, Web Forms & Entity "));
		skill.add(new Skills("OS: ","Windows XP/7/10/Server 2008/12, Ubuntu"));
		skill.add(new Skills("SCM: ","GitLab, GitHub, Sourcetree, Borland Starteam"));
		skill.add(new Skills("Workstation: ", "Visual Studio 2008/17, Eclipse Mars/Oxygen, Visual Studio Code, Notepad++, Delphi XE5"));
		skill.add(new Skills("Apps/Services: ","MsSQL 2008R2/2012, Tomcat, MySQL, Hybris, IBM AS400, VirtualBox"));
		skill.add(new Skills("Hardware: ","RJ-45 Cabling, Cisco RIP/IGRP/EIGRP"));
		
		ArrayList<String>genDuties = new ArrayList<String>();
		genDuties.add("Implement business request system & data changes");
		genDuties.add("Write SQL scripts");
		
		ArrayList<String>appSupport = new ArrayList<String>();
		appSupport.add("Triage reported issues to determine root cause");
		appSupport.add("Based on results, make code changes");
		
		ArrayList<String>projDetails = new ArrayList<String>();
		projDetails.add("Hybris go Live");
		projDetails.add("Delphi switch to XE5/FireDac");
		projDetails.add("Cust. Maigration to Hybris");
		
		ArrayList<Experience>experience = new ArrayList<Experience>();
		
		experience.add( new Experience("2013", "Current", "Software Engineer",
										  "Bedford Park ", "Cintas Corp","IL" ,
										  "Direct Sale and Rent Business goods such as Uniforms & floor mats",
										  projDetails,appSupport,genDuties
										));
		
		ArrayList<Education> edu = new ArrayList<Education>();	
		edu.add(new Education("2006", "2012", "Illinois State University", "Normal, IL", "Computer Systems Technology"));
		edu.add(new Education("2002", "2006", "St. Patrick High School", "Chicago, IL", "High School Diploma"));
		
		
		ArrayList<Skill_Years> years = new ArrayList<Skill_Years>();
		years.add(new Skill_Years("Java", "2.5"));
		years.add(new Skill_Years("C#", "3"));
		years.add(new Skill_Years("SQL", "6"));
		
		return new Resume(basic, skill, experience, edu, years);
	}

}
