package com.wileyedge.Student;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;


@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public final ApiException handleAllExceptions(Exception ex, WebRequest req) {
		
		ApiException expResp = new ApiException("Detail Description of the Exception: ",ex.getMessage(),new Date());
		return expResp;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest req) {
		
		ApiException expResp = new ApiException("Requested Student Id is not present in the system",ex.getMessage(),new Date());
		return new ResponseEntity(expResp,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldError = result.getFieldErrors();
		
		List<String> errorList = new ArrayList<>();
		
		for(FieldError fe: fieldError) {
			errorList.add(fe.getDefaultMessage());
		}
		ApiException errorResponse = new ApiException(errorList, ex.getMessage() ,new Date());
		
		return handleExceptionInternal(ex, errorResponse, headers, status, request);
	}

	
}
