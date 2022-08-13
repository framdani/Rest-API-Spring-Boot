package com.example.RESTfulwebservice.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.*;
@RestController
public class UserResource {
	
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retrievAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User retrievUser(@PathVariable long id){
		User user = service.findOne(id);
		if (user == null)
				throw new UserNotFoundException("User Not Found !");
		return user;
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> createUser(@Valid @RequestBody  User user) {
		service.save(user);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable long id) {
		
		User user = service.deleteById(id);
		//System.out.println(user.id);
		if (user == null)
				throw new UserNotFoundException("User Not Found !");
		
		//return user;
	}
	
	
	
	//

}
