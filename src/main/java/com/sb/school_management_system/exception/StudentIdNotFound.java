package com.sb.school_management_system.exception;

public class StudentIdNotFound extends RuntimeException{

	private String message="Student Id is not found in database";

	public String getMessage() {
		return message;
	}
}
