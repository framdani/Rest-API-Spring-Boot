package com.example.RESTfulwebservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.RESTfulwebservice.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler 
extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
		
		ExceptionResponse exResponse = new ExceptionResponse(new Date(),ex.getMessage() ,request.getDescription(false));
		
		return new ResponseEntity<Object>(exResponse, HttpStatus.INTERNAL_SERVER_ERROR );
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request){
		
		ExceptionResponse exResponse = new ExceptionResponse(new Date(),ex.getMessage() ,request.getDescription(false));
		
		return new ResponseEntity<Object>(exResponse, HttpStatus.NOT_FOUND );
	}
	

}