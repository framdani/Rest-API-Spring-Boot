package com.example.RESTfulwebservice.user;

import java.util.Date;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Descript properties")
//@JsonIgnoreProperties(value= {"id"})
public class User {
	
//	@JsonIgnore
	long id;
	
	@Size(min=2, message="Name should have at least 2 chars")
	@ApiModelProperty(notes="Name should at least have 2 chars")
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
