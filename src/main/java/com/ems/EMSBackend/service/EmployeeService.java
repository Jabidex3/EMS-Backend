package com.ems.EMSBackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.EMSBackend.model.Employee;

@Service
public interface EmployeeService {
	public void addEmployee(Employee e);
	public List<Employee> findAll();
	public Employee findEmployeeById(int id);
	public void delete(int id);
}
