package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.JobTitle;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skills;
import com.metacube.training.service.EmailServiceImplementation;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.EmployeeSkillsService;
import com.metacube.training.service.JobDetailsService;
import com.metacube.training.service.JobTitleService;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.SkillsService;
import com.metacube.training.service.UserRoleService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private SkillsService skillsService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private JobDetailsService jobDetailsService;
	@Autowired
	private JobTitleService jobTitleService;
	@Autowired
	private EmployeeSkillsService employeeSkillsService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private EmailServiceImplementation emailServiceImplementation;

	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {

		return new ModelAndView("admin/dashboard", "username", username);
	}

	// For Project

	@RequestMapping(path = "/projects/add", method = RequestMethod.GET)
	public String createproject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/editProject";
	}

	@RequestMapping(path = "projects", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") Project project) {
		if (project != null && project.getId() == 0) {
			projectService.createProject(project);
		} else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/projects";
	}

	@RequestMapping(path = "/projects", method = RequestMethod.GET)
	public String getAllprojects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";
	}

	@RequestMapping(path = "/projects/edit", method = RequestMethod.GET)
	public String editproject(Model model, @RequestParam("id") int id) {
		model.addAttribute("project", projectService.getProjectById(id));
		return "admin/editProject";
	}

	@RequestMapping(path = "/projects/delete", method = RequestMethod.GET)
	public String deleteproject(@RequestParam("id") int id) {
		projectService.deleteProject(id);
		return "redirect:/admin/projects";
	}

	// For Skills

	@RequestMapping(path = "/skills/add", method = RequestMethod.GET)
	public String createSkill(Model model) {
		model.addAttribute("skill", new Skills());
		return "admin/editSkill";
	}

	@RequestMapping(path = "skills", method = RequestMethod.POST)
	public String saveSkill(@ModelAttribute("skill") Skills skill) {
		if (skill != null && skill.getId() == 0) {
			System.out.println("Skills if");
			skillsService.createSkills(skill);
		} else {
			System.out.println("Skills else");
			skillsService.createSkills(skill);
		}
		return "redirect:/admin/skills";
	}

	@RequestMapping(path = "/skills", method = RequestMethod.GET)
	public String getAllSkills(Model model) {
		model.addAttribute("skills", skillsService.getAllSkills());
		return "admin/skills";
	}

	@RequestMapping(path = "/skills/edit", method = RequestMethod.GET)
	public String editSkill(Model model, @RequestParam("id") int id) {
		model.addAttribute("skill", skillsService.getSkillsById(id));
		return "admin/editSkill";
	}

	@RequestMapping(path = "/skills/delete", method = RequestMethod.GET)
	public String deleteSkill(@RequestParam("id") int id) {
		skillsService.deleteSkills(id);
		return "redirect:/admin/skills";
	}

	// For Employee

	@RequestMapping(path = "/employees/add", method = RequestMethod.GET)
	public String createEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "admin/editEmployee";
	}

	@RequestMapping(path = "employees", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		if (employee != null && employee.getId() == 0) {
			employeeService.createEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}
		return "redirect:/admin/employees";
	}

	@RequestMapping(path = "/employees", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "admin/employees";
	}

	@RequestMapping(path = "/employees/edit", method = RequestMethod.GET)
	public String editEmployee(Model model, @RequestParam("id") int id) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "admin/editEmployee";
	}

	@RequestMapping(path = "/employees/delete", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam("id") int id) {
		employeeService.deleteEmployee(id);
		return "redirect:/admin/employees";
	}

	// For JobDetails

	@RequestMapping(path = "/jobDetails/add", method = RequestMethod.GET)
	public String createJobDetail(Model model) {
		model.addAttribute("jobDetail", new JobDetails());
		model.addAttribute("employees", employeeService.getAllEmployees());
		model.addAttribute("jobTitles", jobTitleService.getAllJobTitles());
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/editJobDetail";
	}

	@RequestMapping(path = "jobDetails", method = RequestMethod.POST)
	public String saveJobDetail(
			@ModelAttribute("jobDetail") JobDetails jobDetail) {
		if (jobDetail != null && jobDetail.getId() == 0) {
			jobDetailsService.createJobDetails(jobDetail);
		} else {
			jobDetailsService.updateJobDetails(jobDetail);
		}
		return "redirect:/admin/jobDetails";
	}

	@RequestMapping(path = "/jobDetails", method = RequestMethod.GET)
	public String getAllJobDetails(Model model) {
		model.addAttribute("jobDetails", jobDetailsService.getAllJobDetails());
		return "admin/jobDetails";
	}

	@RequestMapping(path = "/jobDetails/edit", method = RequestMethod.GET)
	public String editJobDetail(Model model, @RequestParam("id") int id) {
		model.addAttribute("jobDetail", jobDetailsService.getJobDetailsById(id));
		return "admin/editJobDetail";
	}

	@RequestMapping(path = "/jobDetails/delete", method = RequestMethod.GET)
	public String deleteJobDetail(@RequestParam("id") int id) {
		jobDetailsService.deleteJobDetails(id);
		return "redirect:/admin/jobDetails";
	}
	
	//For JobTitle
	
	@RequestMapping(path = "/jobTitles/add", method = RequestMethod.GET)
	public String createJobTitle(Model model) {
		model.addAttribute("jobTitle", new JobTitle());
		return "admin/editJobTitle";
	}

	@RequestMapping(path = "jobTitles", method = RequestMethod.POST)
	public String saveJobTitle(
			@ModelAttribute("jobTitle") JobTitle jobTitle) {
		if (jobTitle != null && jobTitle.getJobCode() == 0) {
			jobTitleService.createJobTitle(jobTitle);
		} else {
			jobTitleService.updateJobTitle(jobTitle);
		}
		return "redirect:/admin/jobTitles";
	}

	@RequestMapping(path = "/jobTitles", method = RequestMethod.GET)
	public String getAllJobTitles(Model model) {
		model.addAttribute("jobTitles", jobTitleService.getAllJobTitles());
		return "admin/jobTitles";
	}

	@RequestMapping(path = "/jobTitles/edit", method = RequestMethod.GET)
	public String editJobTitle(Model model, @RequestParam("id") int id) {
		model.addAttribute("jobTitle", jobTitleService.getJobTitleById(id));
		return "admin/editJobTitle";
	}

	@RequestMapping(path = "/jobTitles/delete", method = RequestMethod.GET)
	public String deleteJobTitle(@RequestParam("id") int id) {
		jobTitleService.deleteJobTitle(id);
		return "redirect:/admin/jobTitles";
	}
	
	//For Search 
	
	@RequestMapping(path = "/searchEmployee", method = RequestMethod.GET)
	public String searchEmployee() {
		return "admin/searchEmployee";
	}
	
	@RequestMapping(path = "/searchEmployee", method = RequestMethod.POST)
	public String searchEmployeePost(Model model, @RequestParam("searchBy") String searchBy, 
			@RequestParam("searchValue") String searchValue) {
		if ("By Name".equals(searchBy)) {
			model.addAttribute("employee", employeeService.searchByName(searchValue));
		}
		return "admin/employees";
	}
	
	// For Employee Skills
	
	@RequestMapping(path = "/employeeSkills/add", method = RequestMethod.GET)
	public String createEmployeeSkill(Model model) {
		model.addAttribute("employeeSkill", new EmployeeSkills());
		model.addAttribute("employee", employeeService.getAllEmployees());
		model.addAttribute("skills", skillsService.getAllSkills());
		return "admin/editEmployeeSkill";
	}

	@RequestMapping(path = "employeeSkills", method = RequestMethod.POST)
	public String saveEmployeeSkill(@ModelAttribute("employeeSkill") EmployeeSkills employeeSkills,
			@RequestParam("employeeSkillsId") String employeeSkillId[]) {
		for(int index = 0 ; index < employeeSkillId.length; index++) {
			if (employeeSkills != null && employeeSkills.getId() == 0) {
				employeeSkills.setSkillId(Integer.parseInt(employeeSkillId[index]));
				employeeSkillsService.createEmployeeSkills(employeeSkills);
			} else {
				employeeSkills.setSkillId(Integer.parseInt(employeeSkillId[index]));
				employeeSkillsService.updateEmployeeSkills(employeeSkills);
			}
		}
		return "redirect:/admin/employeeSkills";
	}

	@RequestMapping(path = "/employeeSkills", method = RequestMethod.GET)
	public String getAllEmployeeSkills(Model model) {
		model.addAttribute("employeeSkills", employeeSkillsService.getAllEmployeeSkills());
		return "admin/employeeSkills";
	}

	@RequestMapping(path = "/employeeSkills/edit", method = RequestMethod.GET)
	public String editEmployeeSkill(Model model, @RequestParam("id") int id) {
		model.addAttribute("employeeSkill", employeeSkillsService.getEmployeeSkillsById(id));
		return "admin/editEmployeeSkill";
	}

	@RequestMapping(path = "/employeeSkills/delete", method = RequestMethod.GET)
	public String deleteEmployeeSkill(@RequestParam("id") int id) {
		employeeSkillsService.deleteEmployeeSkills(id);
		return "redirect:/admin/employeeSkills";
	}

	//For Logout
	@RequestMapping("/logout")
	public String logout() {
		return "redirect:/";
	}
	
	//For Forgotten Password
	
	@RequestMapping(value = "forgottenPassword", method = RequestMethod.GET)
	public String forgotten() {
		return "admin/forgottenPassword";
	}
	
	@RequestMapping(value = "forgottenPassword", method = RequestMethod.POST)
	public String forgottenPassword(@RequestParam("emailId") String emailId) {
		Employee employee = employeeService.getEmployeeByEmailId(emailId);
		String msg = "Your current password is: "+employee.getPassword();
		emailServiceImplementation.sendSimpleMessage(emailId, "Forgotten Password", msg);
		return "admin/login";
	}
	
}
