package com.ems.EMSBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ems.EMSBackend.model.Employee;
import com.ems.EMSBackend.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public void addEmployee(Employee e) {
		empRepo.save(e);
	}

	@Override
	public List<Employee> findAll() {
		return empRepo.findAll();
	}

	@Override
	public Employee findEmployeeById(int id) {
		List<Employee> emp = empRepo.findAll();
		for(Employee e:emp) {
			if(e.getId()==id) {
				return e;
			}
		}
		return null;
	}

	@Override
	public void delete(int id) {
		empRepo.deleteById(id);
	}

}
