package com.cldiaz.myResumeRest.controllers;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cldiaz.myResumeRest.config.ConfigProperties;
import com.cldiaz.myResumeRest.dataImport.JsonGetResume;
import com.cldiaz.myResumeRest.dataImport.XmlGetResume;
import com.cldiaz.myResumeRest.email.EmailServiceImpl;
import com.cldiaz.myResumeRest.models.Resume;
import com.cldiaz.myResumeRest.pdfTemplates.StandardResume;

@Controller
@RequestMapping("/")
public class MvcWebController {
	
	@Autowired
	private JsonGetResume jsonGetResume;
	
	@Autowired
	private XmlGetResume xmlGetResume;
	
	@Autowired
	private StandardResume stanResume;
	
	@Autowired
	private EmailServiceImpl email;
	
	private ConfigProperties prop;
	private Resume res;
	
	private String getPropFileType() {
		return prop.getFileType();
	}
	
	private String getPropTemplate() {
		return prop.getTemplate();
	}
	
	@Autowired
	public void setGlobalProperties(ConfigProperties prop) {
		this.prop = prop;
	}
	
	@ModelAttribute("resume")
	public void setResume(Resume res) {
		if ((!prop.getFileType().isEmpty()) && (prop.getFileType().equals("xml"))) {
			this.res = xmlGetResume.getResume(false);
		}
		else {
			this.res = jsonGetResume.getResume(false);
		}
	}
	
	@GetMapping("/")
	public String viewMain(Model model) {
				
		model.addAttribute("basicInfo",res.getBasicInfo());
		
		return "index";
	}
	
	@GetMapping("/home")
	public String viewHome(Model model) {
				
		model.addAttribute("basicInfo",res.getBasicInfo());
		
		return "index";
	}
	
	@GetMapping("/exp")
	public String viewExperience(Model model) {
				
		model.addAttribute("experiences", res.getExperience());
		return "experience";
	}
	
	@GetMapping("/skills")
	public String viewSkills(Model model) {
				
		model.addAttribute("skills", res.getSkills());
		return "skills";
	}
	
	@GetMapping("/edu")
	public String viewEducation(Model model) {
				
		model.addAttribute("educations", res.getEducation());
		return "education";
	}
	
	@GetMapping("/resume")
	public String getResumePdf(Model model) {
		model.addAttribute("resume", res);
		return "resumeView";
	}
	
	@GetMapping("/getRefs")
	public String sendRefsMail() {
		try {
			email.sendTextMail("cldiaz06@gmail.com", "Test Boot Email", "First email from myResumeRest", "cldiaz1066.SpringResume@gmail.com", null);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "email success";
	}
	
}
