package com.cldiaz.myResumeRest.models;

public class Skill_Years {

	private String skill;
	private String year;
	
	public Skill_Years() {}
	
	public Skill_Years(String skill, String year) {
		this.skill = skill;
		this.year = year;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Skill_Years [skill=" + skill + ", year=" + year + "]";
	}
	
	
	
	
}
