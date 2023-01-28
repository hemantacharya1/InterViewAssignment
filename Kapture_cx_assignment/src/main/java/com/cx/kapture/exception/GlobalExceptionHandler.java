package com.cx.kapture.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CallDetailsException.class)
	public ResponseEntity<MyExceptionDetails> callDetailsExceptionHandler(CallDetailsException c, WebRequest req){
		MyExceptionDetails err= new MyExceptionDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(c.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyExceptionDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyExceptionDetails> exceptionHandler(Exception e, WebRequest req){
	
		MyExceptionDetails err= new MyExceptionDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyExceptionDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
}
