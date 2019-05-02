package com.cldiaz.myResumeRest.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cldiaz.myResumeRest.interfaces.GetResume;
import com.cldiaz.myResumeRest.models.Resume;
import com.cldiaz.myResumeRest.pdfTemplates.StandardResume;
import com.itextpdf.text.DocumentException;

@Controller
@RequestMapping("/")
public class MvcWebController {

	@Autowired
	@Qualifier("jsonGetResume")
	private GetResume getResume;
	
	private Resume res;
	

	@ModelAttribute("resume")
	public void setResume(Resume res) {
		this.res = getResume.getResume(false);
	}
	
	@GetMapping("/")
	public String viewIndex(Model model) {
		model.addAttribute("resume", res);
		return "index";
	}
	
	@GetMapping("/linkedin")
	public void redirectLinkedin(HttpServletResponse httpServletResponse) throws IOException{
		System.out.println("Redirect to linkedin");
		httpServletResponse.sendRedirect(res.getBasicInfo().getLinkedin());
	}
	
	@GetMapping("/gitlab")
	public void redirectGitLab(HttpServletResponse httpServletResponse) throws IOException{
		System.out.println("Redirect to gitlab");
		httpServletResponse.sendRedirect(res.getBasicInfo().getGitUrl());
	}
	
//	@GetMapping("/home")
//	public String viewHome(Model model) {
//			
//		model.addAttribute("basicInfo",res.getBasicInfo());
//		
//		return "index";
//	}
	
	
	//	@GetMapping("/resume")
	//	public String getResumePdf(Model model) {
	//		model.addAttribute("resume", res);
	//		return "resumeView";
	//	}
	
	@GetMapping("/resume")
	public ResponseEntity<InputStreamResource> getResumePdf() throws IOException, DocumentException {
				
		ByteArrayInputStream bis = new ByteArrayInputStream(new byte[0]);
		
		StandardResume stan = new StandardResume();
		
		bis = stan.buildResumePdfRest(res);
			
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=resume.pdf");
			
		return ResponseEntity
					.ok()
					.headers(headers)
					.contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
	}
	
}
