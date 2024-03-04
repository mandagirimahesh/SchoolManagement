package com.sb.school_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.school_management_system.dao.SchoolDao;
import com.sb.school_management_system.dto.Branch;
import com.sb.school_management_system.dto.School;
import com.sb.school_management_system.exception.SchoolIdNotFound;
import com.sb.school_management_system.util.ResponseStructure;

@Service
public class SchoolService {
@Autowired
SchoolDao schoolDao;

public ResponseEntity<ResponseStructure<School>> saveSchool(School school) {
	ResponseStructure<School> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.CREATED.value());
	responseStructure.setMessage("School succesfully updated");
	responseStructure.setData(schoolDao.saveSchool(school));
	return new ResponseEntity<ResponseStructure<School>>(responseStructure,HttpStatus.CREATED);
}

public ResponseEntity<ResponseStructure<School>> fetchSchoolById(int id) {
	if(schoolDao.fetchSchoolById(id)!=null) {
	ResponseStructure<School> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.FOUND.value());
	responseStructure.setMessage("School succesfully fetched");
	responseStructure.setData(schoolDao.fetchSchoolById(id));
	return new ResponseEntity<ResponseStructure<School>>(responseStructure,HttpStatus.FOUND);
	}
	else {
		throw new SchoolIdNotFound();
	}
}
	
public ResponseEntity<ResponseStructure<School>> deleteSchool(int id) {
	if(schoolDao.fetchSchoolById(id)!=null) {
	ResponseStructure<School> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("School succesfully deleted");
	responseStructure.setData(schoolDao.deleteSchool(id));
	return new ResponseEntity<ResponseStructure<School>>(responseStructure,HttpStatus.OK);
	}
	else {
		throw new SchoolIdNotFound();
	}
}

public ResponseEntity<ResponseStructure<School>> updateSchool(int id,School school) {
	if(schoolDao.fetchSchoolById(id)!=null) {
	ResponseStructure<School> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("School succesfully updated");
	responseStructure.setData(schoolDao.updateSchool(id, school));
	return new ResponseEntity<ResponseStructure<School>>(responseStructure,HttpStatus.OK);
	}
	else {
		throw new SchoolIdNotFound();
	}
}

public ResponseEntity<ResponseStructure<School>> addNewBranchToExistingSchool(int schoolId,Branch branch) {
	if(schoolDao.fetchSchoolById(schoolId)!=null ) {
	ResponseStructure<School> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("School succesfully updated to new Branch");
	responseStructure.setData(schoolDao.addNewBranchToExistingSchool(schoolId, branch));
	return new ResponseEntity<ResponseStructure<School>>(responseStructure,HttpStatus.OK);
	}
	else {
		throw new SchoolIdNotFound();
	}
}
}
