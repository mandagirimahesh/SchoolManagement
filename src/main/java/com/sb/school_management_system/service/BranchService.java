package com.sb.school_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.school_management_system.dao.BranchDao;
import com.sb.school_management_system.dto.Address;
import com.sb.school_management_system.dto.Branch;
import com.sb.school_management_system.dto.BranchHead;
import com.sb.school_management_system.dto.Student;
import com.sb.school_management_system.dto.Teacher;
import com.sb.school_management_system.exception.BranchIdNotFound;
import com.sb.school_management_system.util.ResponseStructure;


@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;
	
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Branch succesfully inserted");
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int id) {
		if(branchDao.fetchBranchById(id)!=null) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Branch succesfully fetched");
		responseStructure.setData(branchDao.fetchBranchById(id));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new BranchIdNotFound();
		}
	}
		
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {
		if(branchDao.fetchBranchById(id)!=null) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Branch succesfully deleted");
		responseStructure.setData(branchDao.deleteBranch(id));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id,Branch branch) {
		if(branchDao.fetchBranchById(id)!=null) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Branch succesfully updated");
		responseStructure.setData(branchDao.updateBranch(id, branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingBranchHeadToExistingBranch(int branchHeadId,int branchId) {
		if(branchDao.fetchBranchById(branchId)!=null) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Branch succesfully updated to existing branchhead");
		responseStructure.setData(branchDao.addExistingBranchHeadToExistingBranch(branchHeadId, branchId));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(int addressId,int branchId) {
		if(branchDao.fetchBranchById(branchId)!=null) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Branch succesfully updated to existing address");
		responseStructure.setData(branchDao.addExistingAddressToExistingBranch(addressId, branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new BranchIdNotFound();
		}
	}
	
//	public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(int branchId,Address address) {
//		if(branchDao.fetchBranchById(branchId)!=null) {
//		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
//		responseStructure.setStatus(HttpStatus.OK.value());
//		responseStructure.setMessage("Branch succesfully updated to new address");
//		responseStructure.setData(branchDao.addNewAddressToExistingBranch(branchId, address));
//		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
//		}
//		else {
//			throw new BranchIdNotFound();
//		}
//	}
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingSchoolToExistingBranch(int schoolId,int branchId) {
		if(branchDao.fetchBranchById(branchId)!=null) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Branch succesfully updated to existing school");
		responseStructure.setData(branchDao.addExistingSchoolToExistingBranch(schoolId, branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingStudentToExistingBranch(int studentId,int branchId) {
		if(branchDao.fetchBranchById(branchId)!=null) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Branch succesfully updated to existing student");
		responseStructure.setData(branchDao.addExistingStudentToExistingBranch(studentId, branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingTeacherToExistingBranch(int teacherId,int branchId) {
		if(branchDao.fetchBranchById(branchId)!=null) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Branch succesfully updated to existing teacher");
		responseStructure.setData(branchDao.addExistingTeacherToExistingBranch(teacherId, branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addNewStudentToExistingBranch(int branchId,Student student) {
		if(branchDao.fetchBranchById(branchId)!=null) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("new student succesfully updated to existing branch ");
		responseStructure.setData(branchDao.addNewStudentToExistingBranch(branchId, student));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addNewTeacherToExistingBranch(int branchId,Teacher teacher) {
		if(branchDao.fetchBranchById(branchId)!=null) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("New Teacher succesfully updated to existing Branch");
		responseStructure.setData(branchDao.addNewTeacherToExistingBranch(branchId, teacher));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new BranchIdNotFound();
		}
	}
	
//	public ResponseEntity<ResponseStructure<Branch>> addNewBranchHeadToExistingBranch(int branchId,BranchHead branchHead) {
//		if(branchDao.fetchBranchById(branchId)!=null) {
//		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
//		responseStructure.setStatus(HttpStatus.OK.value());
//		responseStructure.setMessage("New BranchHead succesfully updated to existing Branch");
//		responseStructure.setData(branchDao.addNewBranchHeadToExistingBranch(branchId, branchHead));
//		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
//		}
//		else {
//			throw new BranchIdNotFound();
//		}
//	}
}
