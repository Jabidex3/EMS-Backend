package com.ems.EMSBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ems.EMSBackend.model.Employee;
import com.ems.EMSBackend.service.EmployeeService;

@SpringBootApplication
public class EmsBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmsBackendApplication.class, args);
	}
	
	@Autowired
	private EmployeeService es;
	
	@Override
	public void run(String... args) throws Exception {
		es.addEmployee(new Employee("John","Doe","Developer","1234567890",45000,"1-28-2021"));
		es.addEmployee(new Employee("Bob","Bradley","Manager","2222567890",90000,"6-28-2010"));
		es.addEmployee(new Employee("Mary","Allen","Sales","4567898887",70000,"7-29-2016"));
	}

}
