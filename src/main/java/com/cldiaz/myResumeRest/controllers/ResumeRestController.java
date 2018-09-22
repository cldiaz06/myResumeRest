package com.cldiaz.myResumeRest.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cldiaz.myResumeRest.models.Resume;
import com.cldiaz.myResumeRest.servicesImpl.JsonGetResume;
import com.cldiaz.myResumeRest.servicesImpl.StandardResume;
import com.itextpdf.text.DocumentException;

@RestController
@RequestMapping("/rest")
public class ResumeRestController {

	@Autowired
	private JsonGetResume jsonGetResume;
	
	@Autowired
	private StandardResume stan;
	
	@GetMapping("/getResume")
	public Resume getResume() {
	
		Resume resume = jsonGetResume.getResume(false);
		return resume;
	}
	
	@RequestMapping(value ="/getResumePdf", method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> getResumePdf() throws IOException, DocumentException {
		
		Resume resume = jsonGetResume.getResume(false);
		
		ByteArrayInputStream bis = stan.buildResumePdfRest(resume);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=resume.pdf");
		
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
}
