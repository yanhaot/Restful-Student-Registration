package com.wileyedge.Student;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiException {

	private String message;
	private String details;
	private Date timeStamp;
	private List<String> fieldErrors = new ArrayList<>();
	
	
	public ApiException(String message, String details, Date timeStamp) {
		super();
		this.message = message;
		this.details = details;
		this.timeStamp = timeStamp;
	}
	
	public ApiException(List<String> fieldErrors, String details, Date timeStamp) {
		super();
		this.fieldErrors = fieldErrors;
		this.details = details;
		this.timeStamp = timeStamp;
	}
	
	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public List<String> getFieldErrors() {
		return fieldErrors;
	}

	
}
