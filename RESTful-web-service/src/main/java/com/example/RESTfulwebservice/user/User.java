package com.example.RESTfulwebservice.user;

import java.util.Date;

public class User {
	
	long id;
	String name;
	Date bithDay;
	public User(long id, String name, java.util.Date date) {
		super();
		this.id = id;
		this.name = name;
		this.bithDay = date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBithDay() {
		return bithDay;
	}
	public void setBithDay(Date bithDay) {
		this.bithDay = bithDay;
	}

}
