package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	// add exception handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponce> handleException(StudentNotFoundException exc) {

		// create a StudentErrorResponce
		StudentErrorResponce error = new StudentErrorResponce();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return Responce Entity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// add another exception handeler which catches any exception

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponce> handleAnyException(Exception exc) {

		// create a StudentErrorResponce
		StudentErrorResponce error = new StudentErrorResponce();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return Responce Entity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
