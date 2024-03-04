package com.sb.school_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.school_management_system.dto.Admin;
import com.sb.school_management_system.dto.School;
import com.sb.school_management_system.repo.AdminRepo;

@Repository
public class AdminDao {
	@Autowired
	AdminRepo adminRepo;

	@Autowired
	SchoolDao schoolDao;

	public Admin saveAdmin(Admin admin) {
		return adminRepo.save(admin);
	}

	public Admin fetchAdminById(int id) {
		// return adminRepo.findById(id).get();
		Optional<Admin> admin = adminRepo.findById(id);
		if (admin.isPresent()) {
			return admin.get();
		} else {
			return null;
		}
	}

	public Admin deleteAdmin(int id) {
		Admin admin = fetchAdminById(id);
		adminRepo.delete(admin);
		return admin;
	}

	public Admin updateAdmin(int id, Admin admin) {
		admin.setAdminId(id);
		return adminRepo.save(admin);
	}

	public Admin addExistingSchoolToExistingAdmin(int adminId, int schoolId) {
		Admin admin = fetchAdminById(adminId);
		School school = schoolDao.fetchSchoolById(schoolId);
		admin.setSchool(school);
		return adminRepo.save(admin);
	}
}
