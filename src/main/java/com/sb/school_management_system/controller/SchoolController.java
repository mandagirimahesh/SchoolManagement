package com.sb.school_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.school_management_system.dto.Branch;
import com.sb.school_management_system.dto.School;
import com.sb.school_management_system.service.SchoolService;
import com.sb.school_management_system.util.ResponseStructure;

@RestController
public class SchoolController {
	@Autowired
	SchoolService schoolService;

	@PostMapping("/saveSchool")
	public ResponseEntity<ResponseStructure<School>> saveSchool(@RequestBody School school) {
		return schoolService.saveSchool(school);
	}

	@GetMapping("/fetchSchoolById")
	public ResponseEntity<ResponseStructure<School>> fetchSchoolById(int id) {
		return schoolService.fetchSchoolById(id);
	}

	@DeleteMapping("/deleteSchool")
	public ResponseEntity<ResponseStructure<School>> deleteSchool(int id) {
		return schoolService.deleteSchool(id);
	}

	@PutMapping("/updateSchool")
	public ResponseEntity<ResponseStructure<School>> updateSchool(int id, @RequestBody School school) {
		return schoolService.updateSchool(id, school);
	}

	@PutMapping("/addNewBranchToExistingSchool")
	public ResponseEntity<ResponseStructure<School>> addNewBranchToExistingSchool(int schoolId,
			@RequestBody Branch branch) {
		return schoolService.addNewBranchToExistingSchool(schoolId, branch);
	}
}
