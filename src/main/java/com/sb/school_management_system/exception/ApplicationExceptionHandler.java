package com.sb.school_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sb.school_management_system.util.ResponseStructure;
import com.sb.school_management_system.util.ResponseStructure1;

@RestControllerAdvice
public class ApplicationExceptionHandler {
 @ExceptionHandler(AdminIdNotFound.class)
	public ResponseEntity< ResponseStructure1<String> > adminIdNotFoundException(AdminIdNotFound adminIdNotFound) {
	 ResponseStructure1<String> responseStructure1=new ResponseStructure1<>();
	 responseStructure1.setStatus(HttpStatus.NOT_FOUND.value());
	 responseStructure1.setMessage("Admin not found");
		return new ResponseEntity<ResponseStructure1<String>>(responseStructure1,HttpStatus.NOT_FOUND);
	}
 
 @ExceptionHandler(AddressIdNotFound.class)
 public ResponseEntity< ResponseStructure1<String> > addressIdNotFoundException(AddressIdNotFound addressIdNotFound) {
	 ResponseStructure1<String> responseStructure1=new ResponseStructure1<>();
	 responseStructure1.setStatus(HttpStatus.NOT_FOUND.value());
	 responseStructure1.setMessage("Address not found");
	 return new ResponseEntity<ResponseStructure1<String>>(responseStructure1,HttpStatus.NOT_FOUND);
	}
 
 @ExceptionHandler(BranchHeadIdNotFound.class)
 public ResponseEntity< ResponseStructure1<String> > BranchHeadIdNotFoundException(BranchHeadIdNotFound branchHeadIdNotFound) {
	 ResponseStructure1<String> responseStructure1=new ResponseStructure1<>();
	 responseStructure1.setStatus(HttpStatus.NOT_FOUND.value());
	 responseStructure1.setMessage("BranchHead not found");
		return new ResponseEntity<ResponseStructure1<String>>(responseStructure1,HttpStatus.NOT_FOUND);
	}
 
 @ExceptionHandler(BranchIdNotFound.class)
 public ResponseEntity< ResponseStructure1<String> > BranchIdNotFoundException(BranchIdNotFound branchIdNotFound) {
	 ResponseStructure1<String> responseStructure1=new ResponseStructure1<>();
	 responseStructure1.setStatus(HttpStatus.NOT_FOUND.value());
	 responseStructure1.setMessage("Branch not found");	
	 return new ResponseEntity<ResponseStructure1<String>>(responseStructure1,HttpStatus.NOT_FOUND);
	}
 
 @ExceptionHandler(SchoolIdNotFound.class)
 public ResponseEntity< ResponseStructure1<String> > SchoolIdNotFoundException(SchoolIdNotFound schoolIdNotFound) {
	 ResponseStructure1<String> responseStructure1=new ResponseStructure1<>();
	 responseStructure1.setStatus(HttpStatus.NOT_FOUND.value());
	 responseStructure1.setMessage("School not found");
		return new ResponseEntity<ResponseStructure1<String>>(responseStructure1,HttpStatus.NOT_FOUND);
	}
 
 @ExceptionHandler()
 public ResponseEntity< ResponseStructure1<String> > StudentIdNotFoundException(StudentIdNotFound studentIdNotFound) {
	 ResponseStructure1<String> responseStructure1=new ResponseStructure1<>();
	 responseStructure1.setStatus(HttpStatus.NOT_FOUND.value());
	 responseStructure1.setMessage("Student not found");	
	 return new ResponseEntity<ResponseStructure1<String>>(responseStructure1,HttpStatus.NOT_FOUND);
	}
 
 @ExceptionHandler(TeacherIdNotFound.class)
 public ResponseEntity< ResponseStructure1<String> > TeacherIdNotFoundException(TeacherIdNotFound teacherIdNotFound) {
	 ResponseStructure1<String> responseStructure1=new ResponseStructure1<>();
	 responseStructure1.setStatus(HttpStatus.NOT_FOUND.value());
	 responseStructure1.setMessage("Teacher not found");	
	 return new ResponseEntity<ResponseStructure1<String>>(responseStructure1,HttpStatus.NOT_FOUND);
	}
}
