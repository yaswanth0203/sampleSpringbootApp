package com.verizon.tls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.tls.model.Employee;
import com.verizon.tls.service.IEmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService empServ;
	
	@GetMapping("/listEmps")
	public ModelAndView listEmployees(){
		return new ModelAndView("empList","emps",empServ.listEmployees());
	}
	
	@GetMapping("/addEmp")
	public ModelAndView addEmployees(){
		return new ModelAndView("addEmp","emp",new Employee());
	}
	
	@PostMapping("/addEmp")
	public ModelAndView adddEmployees(){
		return new ModelAndView("addEmp","emp",new Employee());
	}
	
	
}
