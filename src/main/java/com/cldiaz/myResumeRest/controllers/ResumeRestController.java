package com.cldiaz.myResumeRest.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cldiaz.myResumeRest.config.ConfigProperties;
import com.cldiaz.myResumeRest.dataImport.JsonGetResume;
import com.cldiaz.myResumeRest.dataImport.XmlGetResume;
import com.cldiaz.myResumeRest.interfaces.GetResume;
import com.cldiaz.myResumeRest.models.Resume;
import com.cldiaz.myResumeRest.pdfTemplates.StandardResume;
import com.itextpdf.text.DocumentException;

@RestController
@RequestMapping("/rest")
public class ResumeRestController {

	@Autowired
	private JsonGetResume jsonGetResume;
	
	@Autowired
	private XmlGetResume xmlGetResume;
	
	@Autowired
	private StandardResume stan;

	private ConfigProperties prop;
	private Resume res;
	
	@Autowired
	public void setGlobalProperties(ConfigProperties prop) {
		this.prop = prop;
	}
	
	private String getPropFileType() {
		return prop.getFileType();
	}
	
	private String getPropTemplate() {
		return prop.getTemplate();
	}
	
	@GetMapping(value="/getResume/", produces="application/json")
	//@CrossOrigin(origins ="http://localhost:3000")
	public Resume getResume() {
		
		res = jsonGetResume.getResume(false);		
		
		return res;
	}
	
	@GetMapping(value="/getResume/xml", produces="application/xml")
	public Resume getResumeXml() {
		
		res = xmlGetResume.getResume(false);		
		
		return res;
	}
	
	@GetMapping(value ="/getResume/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> getResumePdf() throws IOException, DocumentException {
		
		String fileType = getPropFileType();
		String template = getPropTemplate();
		
		ByteArrayInputStream bis = new ByteArrayInputStream(new byte[0]);
		
		if(!fileType.isEmpty()){
			if (fileType.equals("json")){
				res = jsonGetResume.getResume(false);
			}
			else if(fileType.equals("xml")) {
				res = xmlGetResume.getResume(false);
			}
			else {
				res = null;
			}
		}
		
		if(!template.isEmpty()) {

			if (template.equals("standard")){
				bis = stan.buildResumePdfRest(res);
			}
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=resume.pdf");
			
			return ResponseEntity
					.ok()
					.headers(headers)
					.contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		} else {
			return null;
		}

	}
	
	
	
}
