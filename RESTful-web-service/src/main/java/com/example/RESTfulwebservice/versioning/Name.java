package com.example.RESTfulwebservice.versioning;

public class Name {
	
	private String FistName;
	private String LastName;
	
	
	public Name() { 
	}
	public String getFistName() {
		return FistName;
	}
	public void setFistName(String fistName) {
		FistName = fistName;
	}
	public String getLastName() {
		return LastName;
	}
	public Name(String fistName, String lastName) {
		super();
		FistName = fistName;
		LastName = lastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	

}
