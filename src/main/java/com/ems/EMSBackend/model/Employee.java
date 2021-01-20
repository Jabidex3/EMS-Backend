package com.ems.EMSBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String fname;
	private String lname;
	private String department;
	private String contactNumber;
	private double salary;
	private String hireDate;
	
	public Employee() {
		super();
	}

	public Employee(String fname, String lname, String department, String contactNumber, double salary,
			String hireDate) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.department = department;
		this.contactNumber = contactNumber;
		this.salary = salary;
		this.hireDate = hireDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", department=" + department
				+ ", contactNumber=" + contactNumber + ", salary=" + salary + ", hireDate=" + hireDate + "]";
	}
	
	
}
