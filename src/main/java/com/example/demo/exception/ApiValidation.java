package com.example.demo.exception;

public class ApiValidation {
	private String errorCode;
	private String message;
	public ApiValidation(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public ApiValidation() {
		super();
	}
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
