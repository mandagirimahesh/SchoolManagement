package com.sb.school_management_system.exception;

public class BranchIdNotFound extends RuntimeException{

	private String message="Branch Id is not found in database";

	public String getMessage() {
		return message;
	}
}
