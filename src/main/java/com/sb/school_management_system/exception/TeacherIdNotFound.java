package com.sb.school_management_system.exception;

public class TeacherIdNotFound extends RuntimeException {

	private String message="Teacher Id is not found in database";

	public String getMessage() {
		return message;
	}
}
