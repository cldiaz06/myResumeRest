package com.cldiaz.myResumeRest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MvcWebController {

	@GetMapping("/home")
	public String viewHome(Model model) {
		
		model.addAttribute("message","Welcome to Spring and Thymeleaf");
		
		return "index";
	}
	
}
