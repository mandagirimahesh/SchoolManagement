package com.sb.school_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.school_management_system.dto.Address;
import com.sb.school_management_system.dto.Branch;
import com.sb.school_management_system.dto.BranchHead;
import com.sb.school_management_system.dto.Student;
import com.sb.school_management_system.dto.Teacher;
import com.sb.school_management_system.service.BranchService;
import com.sb.school_management_system.util.ResponseStructure;

@RestController
public class BranchController {
	
@Autowired
BranchService branchService;

@PostMapping("/saveBranch")
public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
	return branchService.saveBranch(branch);
}

@GetMapping("/fetchBranchById")
public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int id) {
	return branchService.fetchBranchById(id);
}
	
@DeleteMapping("/deleteBranch")
public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {
	return branchService.deleteBranch(id);
}

@PutMapping("/updateBranch")
public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id,@RequestBody Branch branch) {
	return branchService.updateBranch(id, branch);
}

@PutMapping("/addExistingBranchHeadToExistingBranch")
public ResponseEntity<ResponseStructure<Branch>> addExistingBranchHeadToExistingBranch(int branchHeadId,int branchId) {
			return branchService.addExistingBranchHeadToExistingBranch(branchHeadId, branchId);
}

@PutMapping("/addExistingAddressToExistingBranch")
public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(int addressId,int branchId) {
	return branchService.addExistingAddressToExistingBranch(addressId, branchId);
}

//@PutMapping("/addNewAddressToExistingBranch")
//public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(int branchId,@RequestBody Address address) {
//	return branchService.addNewAddressToExistingBranch(branchId, address);
//}

@PutMapping("/addExistingSchoolToExistingBranch")
public ResponseEntity<ResponseStructure<Branch>> addExistingSchoolToExistingBranch(int schoolId,int branchId) {
	return branchService.addExistingSchoolToExistingBranch(schoolId, branchId);
}

@PutMapping("/addExistingStudentToExistingBranch")
public ResponseEntity<ResponseStructure<Branch>> addExistingStudentToExistingBranch(int studentId,int branchId) {
	return branchService.addExistingStudentToExistingBranch(studentId, branchId);
}

@PutMapping("/addExistingTeacherToExistingBranch")
public ResponseEntity<ResponseStructure<Branch>> addExistingTeacherToExistingBranch(int teacherId,int branchId) {
	return branchService.addExistingTeacherToExistingBranch(teacherId, branchId);
}

@PutMapping("/addNewStudentToExistingBranch")
public ResponseEntity<ResponseStructure<Branch>> addNewStudentToExistingBranch(int branchId,@RequestBody Student student) {
	return branchService.addNewStudentToExistingBranch(branchId, student);
}

//@PutMapping("/addNewBranchHeadToExistingBranch")
//public ResponseEntity<ResponseStructure<Branch>> addNewBranchHeadToExistingBranch(int branchId,@RequestBody BranchHead branchHead) {
//	return branchService.addNewBranchHeadToExistingBranch(branchId, branchHead);
//}

@PutMapping("/addNewTeacherToExistingBranch")
public ResponseEntity<ResponseStructure<Branch>> addNewTeacherToExistingBranch(int branchId,@RequestBody Teacher teacher) {
	return branchService.addNewTeacherToExistingBranch(branchId, teacher);
}
} 
