package com.example.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

import org.springframework.http.HttpStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoDataException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter private String resourceName;
	@Getter @Setter private String fieldName;
	@Getter @Setter  private Object fieldValue;
	
	 public NoDataException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;{
		// TODO Auto-generated constructor stub
	}
	
	 
	 }
	 
}




