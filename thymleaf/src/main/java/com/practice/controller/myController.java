package com.practice.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class myController {
	
	@GetMapping("/about")
	public String about(Model model) {
		System.out.println("inside about handler");
		
		model.addAttribute("name","Entity_303");
		
		return "about";
		// we need to show about.html
	}
	
	@GetMapping("/loop")
	public String iterationHandler(Model model) {
		
		List<String> res = List.of("jyot","ravi bhaiya","abhijeet bhaiya", "datta");
		
		model.addAttribute("friends",res);
		
		return "iterate";
	}
	
	@GetMapping("/condition")
	public String conditionHandler(Model model) {
		
		model.addAttribute("isActive",true);
		model.addAttribute("Gender","M");
		
		return "condition";
	}
	
	// handler for including fragments
	
	@GetMapping("/service")
	public String serviceHandler(Model model) {
		return "service";
	}
}