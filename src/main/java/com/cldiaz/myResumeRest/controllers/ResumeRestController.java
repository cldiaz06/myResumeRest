package com.cldiaz.myResumeRest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cldiaz.myResumeRest.models.Resume;
import com.cldiaz.myResumeRest.servicesImpl.JsonGetResume;

@RestController
@RequestMapping("/rest")
public class ResumeRestController {
	
	@Autowired
	private JsonGetResume jsonGetResume;
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}
	
	@GetMapping("/getResume")
	public Resume getResume() {
	
		Resume resume = jsonGetResume.getResume(false);
		return resume;
	}
	
	@GetMapping("/getResumePdf")
	public Resume getResumePdf() {
		Resume resume = jsonGetResume.getResume(false);
		return resume;
	}
}
