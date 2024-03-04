package com.sb.school_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.school_management_system.dto.Address;
import com.sb.school_management_system.dto.Admin;
import com.sb.school_management_system.dto.Branch;
import com.sb.school_management_system.dto.BranchHead;
import com.sb.school_management_system.dto.School;
import com.sb.school_management_system.dto.Student;
import com.sb.school_management_system.dto.Teacher;
import com.sb.school_management_system.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	BranchRepo branchRepo;
	
	@Autowired
	BranchHeadDao branchHeadDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	SchoolDao schoolDao;
	@Autowired
	StudentDao studentDao;
	@Autowired
	TeacherDao teacherDao;
	
	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}

	public Branch fetchBranchById(int id) {
		Optional<Branch> branch=branchRepo.findById(id);
		if(branch.isPresent()) {
		return branchRepo.findById(id).get();
		}
		else {
			return null;
		}
	}
		
	public Branch deleteBranch(int id) {
		Branch branch=fetchBranchById(id);
		branchRepo.delete(branch);
		return branch;
	}

	public Branch updateBranch(int id,Branch branch) {
		branch.setBranchId(id);
		return branchRepo.save(branch);
	}

	public Branch addExistingBranchHeadToExistingBranch(int branchHeadId,int branchId) {
		Branch branch=fetchBranchById(branchId);
		BranchHead BranchHead=branchHeadDao.fetchBranchHeadById(branchHeadId);
		branch.setBranchHead(BranchHead);
		return branchRepo.save(branch);
	}
	
	public Branch addExistingAddressToExistingBranch(int addressId,int branchId) {
	Branch branch=fetchBranchById(branchId);
	Address address=addressDao.fetchAddressById(addressId);
	branch.setAddress(address);
	return saveBranch(branch);
	}
	
	public Branch addNewAddressToExistingBranch(int branchId,Address address) {
		Branch branch=fetchBranchById(branchId);
		address.setAddressId(branchId);
        return saveBranch(branch);		
	}
	
	public Branch addNewBranchHeadToExistingBranch(int branchId,BranchHead branchHead) {
		Branch branch=fetchBranchById(branchId);
		branchHead.setBranchHeadId(branchId);
		return saveBranch(branch);
		
	}
	
	public Branch addExistingSchoolToExistingBranch(int schoolId,int branchId) {
	Branch branch =	fetchBranchById(branchId);
	School school =schoolDao.fetchSchoolById(schoolId);
	branch.getSchool().add(school);
	return saveBranch(branch);
	}
	
	public Branch addExistingStudentToExistingBranch(int studentId,int branchId) {
		Branch branch =fetchBranchById(branchId);
       Student student =  studentDao.fetchStudentById(studentId);
       branch.getStudent().add(student);
       return saveBranch(branch);
	}
	
	public Branch addExistingTeacherToExistingBranch(int teacherId,int branchId) {
		Branch branch =fetchBranchById(branchId);
        Teacher teacher =teacherDao.fetchTeacherById(teacherId);
        branch.getTeacher().add(teacher);
        return saveBranch(branch);
	}
	
	public Branch addNewStudentToExistingBranch(int branchId,Student student) {
	Branch branch=fetchBranchById(branchId);
	branch.getStudent().add(student);
	return saveBranch(branch);
	}
	
	public Branch addNewTeacherToExistingBranch(int branchId,Teacher teacher) {
		Branch branch =fetchBranchById(branchId);
		branch.getTeacher().add(teacher);
		return saveBranch(branch);	
	}
	
	
}
