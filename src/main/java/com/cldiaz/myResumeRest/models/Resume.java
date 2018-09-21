package com.cldiaz.myResumeRest.models;

import java.util.ArrayList;
import java.util.List;

public class Resume {

	private BasicInfo basicInfo = new BasicInfo();
	private ArrayList<Skills> skills = new ArrayList<Skills>();
	private ArrayList<Experience> experience = new ArrayList<Experience>();
	private ArrayList<Education> education = new ArrayList<Education>();
	private String format = new String();
	
	public Resume() {}

	public Resume(BasicInfo basicInfo, ArrayList<Skills> skills, ArrayList<Experience> experience,
			ArrayList<Education> education, String format) {
		super();
		this.basicInfo = basicInfo;
		this.skills = skills;
		this.experience = experience;
		this.education = education;
		this.format = format;
	}

	public Resume(BasicInfo basic, List<Skills> skill, List<Experience> exp, List<Education> edu, String string) {
		this.basicInfo = basic;
		this.skills = (ArrayList<Skills>) skill;
		this.experience = (ArrayList<Experience>) exp;
		this.education = (ArrayList<Education>) edu;
		this.format = format;
	}

	public BasicInfo getBasicInfo() {
		return basicInfo;
	}

	public void setBasicInfo(BasicInfo basicInfo) {
		this.basicInfo = basicInfo;
	}

	public ArrayList<Skills> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<Skills> skills) {
		this.skills = skills;
	}

	public ArrayList<Experience> getExperience() {
		return experience;
	}

	public void setExperience(ArrayList<Experience> experience) {
		this.experience = experience;
	}

	public ArrayList<Education> getEducation() {
		return education;
	}

	public void setEducation(ArrayList<Education> education) {
		this.education = education;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return "Resume [basicInfo=" + basicInfo + ", skills=" + skills + ", experience=" + experience + ", education="
				+ education + ", format=" + format + "]";
	}
	
	
	
}
