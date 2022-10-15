package com.wileyedge.Student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // => 404 Response
public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(String msg) {
		super(msg);
	}
}
