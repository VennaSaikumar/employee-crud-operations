package com.nit.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEmployeeNotFound(EmployeeNotFoundException ex){
		
		ErrorResponse error=new ErrorResponse(
				"FAILED",
				"DEP007",
				ex.getMessage()
				);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationErrors(
	        MethodArgumentNotValidException exception) {

	    Map<String, String> errors = new HashMap<>();

	    exception.getBindingResult()
	            .getFieldErrors()
	            .forEach(error ->
	                    errors.put(error.getField(), error.getDefaultMessage()));

	    ErrorResponse response = new ErrorResponse(
	            "400",
	            "VALIDATION_ERROR",
	            errors
	    );

	    return ResponseEntity
	            .status(HttpStatus.BAD_REQUEST)
	            .body(response);
	}
}