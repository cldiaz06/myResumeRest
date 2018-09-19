package com.cldiaz.myResumeRest.models;

public class BasicInfo {

	private String fullName;
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	private String postalcode;
	private String title;
	private String phone;
	private String email;
	private String git_url;
	private String address;
	
	public BasicInfo() {}
	
	public BasicInfo(String firstName, String lastName, String city, String state, String postalcode, String title,
			String phone, String email, String git_url) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.postalcode = postalcode;
		this.title = title;
		this.phone = phone;
		this.email = email;
		this.git_url = git_url;
		this.fullName = firstName + " "+ lastName;
		this.address = city + ", " + state; 
	}

	public String getFullName() {
		return fullName;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public String getTitle() {
		return title;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getGit_url() {
		return git_url;
	}

	public String getAddress() {
		return address;
	}
	
	
	
}
