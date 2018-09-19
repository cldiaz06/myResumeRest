package com.cldiaz.myResumeRest.models;

public class Education {

	private String startDate;
	private String endDate;
	private String schoolName;
	private String location;
	private String achievement;
	
	public Education() {}
	
	public Education(String startDate, String endDate, String schoolName, String location, String achievement) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.schoolName = schoolName;
		this.location = location;
		this.achievement = achievement;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public String getLocation() {
		return location;
	}

	public String getAchievement() {
		return achievement;
	}
	
	
	
}
