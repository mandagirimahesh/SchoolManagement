package com.sb.school_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.school_management_system.dao.BranchHeadDao;
import com.sb.school_management_system.dto.Address;
import com.sb.school_management_system.dto.BranchHead;
import com.sb.school_management_system.exception.BranchHeadIdNotFound;
import com.sb.school_management_system.util.ResponseStructure;

@Service
public class BranchHeadService {
@Autowired
BranchHeadDao branchHeadDao;

public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(BranchHead branchHead) {
	
	ResponseStructure<BranchHead> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.CREATED.value());
	responseStructure.setMessage("Admin succesfully inserted");
	responseStructure.setData(branchHeadDao.saveBranchHead(branchHead));
	return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.CREATED);
}

public ResponseEntity<ResponseStructure<BranchHead>> fetchBranchHeadById(int id) {
	if(branchHeadDao.fetchBranchHeadById(id)!=null) {
	ResponseStructure<BranchHead> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.FOUND.value());
	responseStructure.setMessage("Admin succesfully fetched");
	responseStructure.setData(branchHeadDao.fetchBranchHeadById(id));
	return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.FOUND);
	}
	else {
		throw new BranchHeadIdNotFound();
	}
}
	
public ResponseEntity<ResponseStructure<BranchHead>> deleteBranchHead(int id) {
	if(branchHeadDao.fetchBranchHeadById(id)!=null) {
	ResponseStructure<BranchHead> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Admin succesfully deleted");
	responseStructure.setData(branchHeadDao.deleteBranchHead(id));
	return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.OK);
	}
	else {
throw new BranchHeadIdNotFound();
	}
}

public ResponseEntity<ResponseStructure<BranchHead>> updateBranchHead(int id,BranchHead branchHead) {
	if(branchHeadDao.fetchBranchHeadById(id)!=null) {
	ResponseStructure<BranchHead> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Admin succesfully updated");
	responseStructure.setData(branchHeadDao.updateBranchHead(id, branchHead));
	return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.OK);
	}
	else {
		throw new BranchHeadIdNotFound();
	}
}
}
