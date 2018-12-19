package com.cldiaz.myResumeRest.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cldiaz.myResumeRest.config.ConfigProperties;
import com.cldiaz.myResumeRest.interfaces.GetResume;
import com.cldiaz.myResumeRest.models.Resume;

@Controller
@RequestMapping("/")
public class MvcWebController {

	@Autowired
	@Qualifier("jsonGetResume")
	private GetResume getResume;
	
	private ConfigProperties prop;
	private Resume res;
	
	@Autowired
	public void setGlobalProperties(ConfigProperties prop) {
		this.prop = prop;
	}

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
		System.out.println("Redirect to linkedin");
		httpServletResponse.sendRedirect(res.getBasicInfo().getGitUrl());
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
	
	@GetMapping("/years")
	public String viewSkillYears(Model model) {
				
		model.addAttribute("skill_years", res.getYears());
		return "skillYears";
	}
	
	@GetMapping("/resume")
	public String getResumePdf(Model model) {
		model.addAttribute("resume", res);
		return "resumeView";
	}
	
}
