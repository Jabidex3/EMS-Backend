package com.ems.EMSBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//get all employees
	@GetMapping("employees")
	public List<Employee> getEmployees(){
		return this.es.findAll();
	}
	
	//add a new employee
	@PostMapping("add")
	public Employee addEmployee(@RequestBody Employee e){
//		Employee newEmp = new Employee();
//		return newEmp;
		es.addEmployee(e);
		return e;
	}
	
	//delete an existing employee
	@DeleteMapping("delete/{id}")
	public boolean deleteEmployee(@PathVariable int id) { 
		List<Employee> allEmp = es.findAll();
		for(int i =0;i<allEmp.size();i++) {
			if(allEmp.get(i).getId()==id) {
				allEmp.remove(i);
				return true;
			}
		}
		
		return false; //not found
	}
}
