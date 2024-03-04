package com.sb.school_management_system.exception;

public class SchoolIdNotFound extends RuntimeException {

	private String message="School Id is not found in database.";

	public String getMessage() {
		return message;
	}
}
