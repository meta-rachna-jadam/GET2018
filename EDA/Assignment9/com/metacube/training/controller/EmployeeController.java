package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Project;
import com.metacube.training.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "employee/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {

		return new ModelAndView("employee/dashboard", "username", username);
	}
	
	@RequestMapping(path = "/edit", method = RequestMethod.GET)
	public String editEmployee(Model model, @RequestParam("emailId") String emailId) {
		System.out.println("emailId = "+emailId);
		model.addAttribute("employee", employeeService.getEmployeeByEmailId(emailId));
		return "employee/employees";
	}
	
	@RequestMapping(path = "/edit", method = RequestMethod.POST)
	public ModelAndView saveproject(@ModelAttribute("employee") Employee employee) {
		employeeService.updateEmployee(employee);
		return new ModelAndView("employee/dashboard", "username", employee.getEmailId());
	}

	@RequestMapping("/logout")
	public String logout() {
		return "redirect:/";
	}
}
