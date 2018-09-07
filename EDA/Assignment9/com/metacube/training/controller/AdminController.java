package com.metacube.training.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Skills;
import com.metacube.training.service.SkillsService;

@Controller
@RequestMapping("/admin")
public class AdminController  {

	@RequestMapping(value = "/login")
	public String login() {
		
		return "admin/login";
	}
	
	@RequestMapping(value="/dashboard")
	public String getDashboard() {
		System.out.println("dashboad");
		return "admin/dashboard";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, 
			@RequestParam("password") String password){
		System.out.println("login post");
		System.out.println("userName "+username);
		return "redirect:/admin/dashboard";
	}
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String addProject(){
		System.out.println("project get");
		return "admin/project";
	}
	
	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public String project(@RequestParam("description") String description, @RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate, @RequestParam("logo") MultipartFile logo){
		System.out.println("project post");
		return "redirect:/admin/dashboard";
	}
	
	@RequestMapping(value = "/skills", method = RequestMethod.GET)
	public String addSkill(){
		System.out.println("skils get");
		return "admin/skills";
	}
	
	@RequestMapping(value = "/skills", method = RequestMethod.POST)
	public String addSkill(@RequestParam("skillName") String skillName){
		System.out.println("skils post "+skillName);
		new SkillsService().createField(new Skills(skillName));
		return "redirect:/admin/dashboard";
	}
	
	@RequestMapping(value = "/jobTitle", method = RequestMethod.GET)
	public String addJobTitle(){
		System.out.println("jt get");
		return "admin/jobTitle";
	}
	
	@RequestMapping(value = "/jobTitle", method = RequestMethod.POST)
	public String addJobTitle(@RequestParam("jobTitle") String jobTitle){
		System.out.println("jt post");
		return "redirect:/admin/dashboard";
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmployee(){
		System.out.println("ae get");
		return "admin/addEmployee";
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmployee(@RequestParam("fname") String firstName, @RequestParam("mname") String middleName, 
			@RequestParam("lname") String lastName, @RequestParam("email") String email, @RequestParam("dob") @DateTimeFormat(pattern="yyyy-MM-dd") Date dob, 
			@RequestParam("gender") String gender, @RequestParam("doj") @DateTimeFormat(pattern="yyyy-MM-dd") Date doj, @RequestParam("reportingMgr") int reportingMgr, 
			@RequestParam("teamLead") int teamLead, @RequestParam("projectId") int projectId){
		System.out.println("ae post");
		return "redirect:/admin/dashboard";
	}
	
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public String searchEmployee(){
		System.out.println("se get");
		return "admin/searchEmployee";
	}
	
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
	public String searchEmployee(@RequestParam("employeeName") String employeeName){
		System.out.println("se post");
		return "redirect:/admin/dashboard";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(){
		System.out.println("logout");
		return "redirect:/";
	}
}
