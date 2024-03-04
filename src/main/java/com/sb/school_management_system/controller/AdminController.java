package com.sb.school_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.school_management_system.dto.Admin;
import com.sb.school_management_system.service.AdminService;
import com.sb.school_management_system.util.ResponseStructure;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping("/saveAdmin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	@GetMapping("/fetchAdminById")
	public ResponseEntity<ResponseStructure<Admin>> fetchAdminById(int id) {
		return adminService.fetchAdminById(id);
	}

	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int id) {
		return adminService.deleteAdmin(id);
	}

	@PutMapping("/updateAdmin")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(int id, @RequestBody Admin admin) {
		return adminService.updateAdmin(id, admin);
	}

	@PutMapping("/addExistingSchoolToExistingAdmin")
	public ResponseEntity<ResponseStructure<Admin>> addExistingSchoolToExistingAdmin(int adminId, int schoolId) {
		return adminService.addExistingSchoolToExistingAdmin(adminId, schoolId);
	}

}
