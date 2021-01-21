package com.ems.EMSBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.EMSBackend.model.Employee;
import com.ems.EMSBackend.repository.EmployeeRepository;
import com.ems.EMSBackend.service.EmployeeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
//@RequestMapping("employee/")
public class EmployeeController {

	@Autowired
	private EmployeeService es;
	
	@GetMapping("test")
	public String test(){
		return "Hello World";
	}
	
	@GetMapping("employees")
	public List<Employee> getEmployees(){
		return this.es.findAll();
	}
	
	@PostMapping("employee")
	public Employee addEmployee(@RequestBody Employee e){
//		Employee newEmp = new Employee();
//		return newEmp;
		es.addEmployee(e);
		return e;
	}
}
