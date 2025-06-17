package com.eventManagement.EventManagementApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.eventManagement.EventManagementApp.service.ResponseStructure;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException exception){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("failure");
		structure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
	
	 @ExceptionHandler(NoRecordAvailableException.class)
	 public ResponseEntity<ResponseStructure<String>> handleNoRecordAvailableException(NoRecordAvailableException exception){
		 ResponseStructure<String> structure=new ResponseStructure<>();
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("failure");
			structure.setData(exception.getMessage());
			
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
			
		}
		 
	 }
	
