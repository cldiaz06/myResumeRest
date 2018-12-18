package com.cldiaz.myResumeRest.models;

public class Interests {

	private String header;
	private String detail;
	
	public Interests() {}
	
	public Interests(String header, String detail) {
		this.header = header;
		this.detail = detail;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Interests [header=" + header + ", detail=" + detail + "]";
	}

	
	
	
}
