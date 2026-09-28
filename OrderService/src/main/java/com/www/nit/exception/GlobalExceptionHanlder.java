package com.www.nit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHanlder {
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorResponse> OrderNotFoundExceptionHandler(OrderNotFoundException exception){
		ErrorResponse error = new ErrorResponse(
				"FAILED",
				"DEP07",
				exception.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
}
