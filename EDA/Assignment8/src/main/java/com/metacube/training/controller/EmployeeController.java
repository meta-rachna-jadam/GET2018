package com.metacube.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	@RequestMapping("test")
	public String login() {
		return "home";
	}
}
