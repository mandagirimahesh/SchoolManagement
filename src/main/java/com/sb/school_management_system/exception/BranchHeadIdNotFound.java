package com.sb.school_management_system.exception;

public class BranchHeadIdNotFound extends RuntimeException {

	private String message="BranchHead Id is not found in database";

	public String getMessage() {
		return message;
	}
}
