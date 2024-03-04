package com.sb.school_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.school_management_system.dto.Branch;
import com.sb.school_management_system.dto.BranchHead;
import com.sb.school_management_system.repo.BranchHeadRepo;

@Repository
public class BranchHeadDao {
@Autowired
BranchHeadRepo branchHeadRepo;

public BranchHead saveBranchHead(BranchHead branchHead) {
	return branchHeadRepo.save(branchHead);
}

public BranchHead fetchBranchHeadById(int id) {
	Optional<BranchHead> branchHead=branchHeadRepo.findById(id);
	if(branchHead.isPresent()) {
	return branchHeadRepo.findById(id).get();
	}
	else {
		return null;
	}
}
	
public BranchHead deleteBranchHead(int id) {
	BranchHead branchHead=fetchBranchHeadById(id);
	branchHeadRepo.delete(branchHead);
	return branchHead;
}

public BranchHead updateBranchHead(int id,BranchHead branchHead) {
	branchHead.setBranchHeadId(id);
	return branchHeadRepo.save(branchHead);
}
}
