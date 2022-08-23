package com.example.RESTfulwebservice.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("First dynamic Filter")
public class Employer {
	
	private String name;
	private String Salary;
	private String address;
	
	
	public Employer() {
		super();
	}
	public Employer(String name, String salary, String address) {
		super();
		this.name = name;
		Salary = salary;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return Salary;
	}
	public void setSalary(String salary) {
		Salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
