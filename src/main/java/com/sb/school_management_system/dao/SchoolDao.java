package com.sb.school_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.school_management_system.dto.Branch;
import com.sb.school_management_system.dto.School;
import com.sb.school_management_system.repo.SchoolRepo;

@Repository
public class SchoolDao {

	@Autowired
	SchoolRepo schoolRepo;
	
	public School saveSchool(School school) {
		return schoolRepo.save(school);
	}

	public School fetchSchoolById(int id) {
		Optional<School> school=schoolRepo.findById(id);
		if(school.isPresent()) {
		return schoolRepo.findById(id).get();
		}
		else {
			return null;
		}
	}
		
	public School deleteSchool(int id) {
		School school=fetchSchoolById(id);
		schoolRepo.delete(school);
		return school;
	}

	public School updateSchool(int id,School school) {
		school.setSchoolId(id);
		return schoolRepo.save(school);
	}
	
	public School addNewBranchToExistingSchool(int schoolId,Branch branch) {
		School school =fetchSchoolById(schoolId);
		school.getBranch().add(branch);
		return saveSchool(school);
	}
	
	
	
}
