package com.ems.EMSBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.EMSBackend.model.Employee;
import com.ems.EMSBackend.repository.EmployeeRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
//@RequestMapping("employee/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;
	
	@GetMapping("test")
	public String test(){
		return "Hello World";
	}
	
	@GetMapping("employees")
	public List<Employee> getEmployees(){
		return this.empRepo.findAll();
	}
}
