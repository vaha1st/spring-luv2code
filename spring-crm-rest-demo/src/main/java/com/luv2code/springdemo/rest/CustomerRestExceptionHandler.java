package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// add an exception handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc) {

		// create Customer error response
		CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(),
				System.currentTimeMillis());

		// return Response Entity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// add an exception handler for any other exceptions
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleAnyException(Exception exc) {

		// create Customer error response
		CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(),
				System.currentTimeMillis());

		// return Response Entity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
