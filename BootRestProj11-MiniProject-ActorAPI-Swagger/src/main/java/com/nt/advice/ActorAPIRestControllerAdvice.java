package com.nt.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ActorAPIRestControllerAdvice {
 
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIAE(IllegalArgumentException iae)
	{
		return new ResponseEntity<String>("Problem ::"+iae.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleAllException(Exception e)
	{
		return new ResponseEntity<String>("Problem in handling::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
