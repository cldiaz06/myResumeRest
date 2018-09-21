package com.cldiaz.myResumeRest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cldiaz.myResumeRest.models.Resume;
import com.cldiaz.myResumeRest.servicesImpl.JsonGetResume;

@RestController
@RequestMapping("/rest")
public class ResumeRestController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}
	
	@GetMapping("/getResume")
	public Resume getResume() {
		
		JsonGetResume getResume = new JsonGetResume();
		Resume resume = getResume.getResume(false);
		return resume;
	}
}
