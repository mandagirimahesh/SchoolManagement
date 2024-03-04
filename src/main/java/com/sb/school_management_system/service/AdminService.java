package com.sb.school_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.school_management_system.dao.AdminDao;
import com.sb.school_management_system.dao.SchoolDao;
import com.sb.school_management_system.dto.Address;
import com.sb.school_management_system.dto.Admin;
import com.sb.school_management_system.exception.AdminIdNotFound;
import com.sb.school_management_system.util.ResponseStructure;

@Service
public class AdminService {
@Autowired
AdminDao adminDao;
@Autowired
SchoolDao schoolDao;

public ResponseEntity< ResponseStructure<Admin> >saveAdmin(Admin admin) {
	ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.CREATED.value());
	responseStructure.setMessage("Admin succesfully inserted");
	responseStructure.setData(admin);
	return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.CREATED);
}

public ResponseEntity<ResponseStructure<Admin>> fetchAdminById(int id) {
	if(adminDao.fetchAdminById(id)!=null) {
	ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.FOUND.value());
	responseStructure.setMessage("Admin succesfully fetched");
	responseStructure.setData(adminDao.fetchAdminById(id));;
	return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.FOUND);
	}
	else {
		throw new AdminIdNotFound();
	}
}

public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int id) {
	if(adminDao.fetchAdminById(id)!=null) {
	ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Admin succesfully deleted");
	responseStructure.setData(adminDao.deleteAdmin(id));
	return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
	}
	else {
		throw new AdminIdNotFound();
	}
}

public ResponseEntity<ResponseStructure<Admin>> updateAdmin(int id,Admin admin) {
	if(adminDao.fetchAdminById(id)!=null) {
	ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Admin succesfully updated");
	responseStructure.setData(adminDao.updateAdmin(id, admin));
	return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
	}
	else {
		throw new AdminIdNotFound();
	}
}

public ResponseEntity<ResponseStructure<Admin>> addExistingSchoolToExistingAdmin(int adminId,int schoolId) {
	if(adminDao.fetchAdminById(adminId)!=null ) {
	ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Admin succesfully added to existing school");
	responseStructure.setData(adminDao.fetchAdminById(adminId));
	return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
	}
	else {
		throw new AdminIdNotFound();
	}
}
}
