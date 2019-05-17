package com.cldiaz.myResumeRest.interfaces;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import com.cldiaz.myResumeRest.models.BasicInfo;
import com.cldiaz.myResumeRest.models.Education;
import com.cldiaz.myResumeRest.models.Experience;
import com.cldiaz.myResumeRest.models.Resume;
import com.cldiaz.myResumeRest.models.Skills;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

public interface PdfResumeGenerator {
	
	public ByteArrayInputStream buildResumePdfRest(Resume resume) throws DocumentException;
	
	public void addBasicInfo(Document document, BasicInfo basicInfo) throws DocumentException;
	
	public void addSkills(Document document, ArrayList<Skills> skills) throws DocumentException;
	
	public void addExperience(Document document, ArrayList<Experience> experience) throws DocumentException;
	
	public void addEducation(Document document, ArrayList<Education> education) throws DocumentException;
	
}
