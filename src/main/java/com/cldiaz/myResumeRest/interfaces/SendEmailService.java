package com.cldiaz.myResumeRest.interfaces;

import com.cldiaz.myResumeRest.models.Email;

public interface SendEmailService {
	
	public void sendEmail() throws Exception;
	
	public String sendEmail(Email email) throws Exception;
}
