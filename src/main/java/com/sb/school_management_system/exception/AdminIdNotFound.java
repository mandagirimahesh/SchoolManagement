package com.sb.school_management_system.exception;

public class AdminIdNotFound extends RuntimeException {

	private String message="Admin Id is not found";

	public String getMessage() {
		return message;
	}
	
	
}
