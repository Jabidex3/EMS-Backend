package com.ems.EMSBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.EMSBackend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
