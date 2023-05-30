package net.java.springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.java.springboot.model.Employee;
import net.java.springboot.service.EmployeeService;

@Controller

public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	//display list of Employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees",employeeService.getAllEmployees());
		return "index";
}
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		//create model attribute to bind form data 
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	@PostMapping("/saveEmployee")
	public String  saveEmployee(@ModelAttribute("employee") Employee employee) {
		//save Employee to database
		return "redirect:/";
	}
	
}