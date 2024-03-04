package com.sb.school_management_system.exception;

public class AddressIdNotFound extends RuntimeException{

	private String message="Address Id is not found in database.";

	public String getMessage() {
		return message;
	}
	
	
}
