package com.example.RESTfulwebservice.user;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserResource {
	
	
	@Autowired
	private UserDaoService service;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/users")
	public List<User> retrievAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/user/{id}")
	public EntityModel<User> retrievUser(@PathVariable long id){
		User user = service.findOne(id);
		if (user == null)
				throw new UserNotFoundException("User Not Found !");
		
		EntityModel<User> entitymodel = EntityModel.of(user);
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).retrievAllUsers());
		entitymodel.add(link.withRel("all-users"));
		
		return entitymodel;
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
	
	@GetMapping("/home")
	public String HelloWorld(@RequestHeader(name="Accept-Language", required=false) Locale local) {
		return messageSource.getMessage("welcome.text.message", null,local);
	}
	
	
	
	//

}
