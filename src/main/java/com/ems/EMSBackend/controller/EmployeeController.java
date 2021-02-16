package com.ems.EMSBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.EMSBackend.model.Employee;
import com.ems.EMSBackend.repository.EmployeeRepository;
import com.ems.EMSBackend.service.EmployeeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("ems/")
public class EmployeeController {

	@Autowired
	private EmployeeService es;
	
	//get all employees
	@GetMapping("employees")
	public List<Employee> getAllEmployees(){
		return this.es.findAll();
	}
	
	//get employee by id
	@GetMapping("employee/{id}")
	public Employee getEmployeeById(@PathVariable int id){
		Employee emp = es.findEmployeeById(id);
		if(emp != null) {
			return emp;
		}
		return null;
	}
	
	//add a new employee
	@PostMapping("add")
	public Employee addNewEmployee(@RequestBody Employee e){
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
				es.delete(allEmp.get(i).getId());
				return true;
			}
		}
		
		return false; //not found
	}
	
	//Modify an existing employee [by id]
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee u){
		Employee toBeUpdated = es.findEmployeeById(u.getId());
		
		if(toBeUpdated!=null) {
			if(u.getFname()!=null) {
				toBeUpdated.setFname(u.getFname());
			}
			
			if(u.getLname()!=null) {
				toBeUpdated.setLname(u.getLname());
			}
			
			if(u.getDepartment()!=null) {
				toBeUpdated.setDepartment(u.getDepartment());
			}
			
			if(u.getContactNumber()!=null) {
				toBeUpdated.setContactNumber(u.getContactNumber());
			}
			if(u.getSalary()!= 0) {
				toBeUpdated.setSalary(u.getSalary());
			}
			
			es.addEmployee(toBeUpdated);//update existing record in db
			return toBeUpdated;
		}
		else {
			//could not find employee with associated id, so update cant be performed
			return null;
		}
	}
}
