package com.example.RESTfulwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>(); 
	
	static {
		users.add(new User(1, "framdani", new Date()));
		users.add(new User(2, "Iidzim", new Date()));
		users.add(new User(3, "Oel-yous", new Date()));
		
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		users.add(user);
		return user;
	}
	
	public User findOne(long id) {
		for (User user : users) {
			if (user.getId() == id)
				return user;
		}
		return null;
		
	}

}
