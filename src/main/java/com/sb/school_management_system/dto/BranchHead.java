package com.sb.school_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BranchHead {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY )

private int branchHeadId;
private String branchHeadName;
private double branchHeadSalary;
private long branchHeadPhone;
private int branchHeadExperience;
public int getBranchHeadId() {
	return branchHeadId;
}
public void setBranchHeadId(int branchHeadId) {
	this.branchHeadId = branchHeadId;
}
public String getBranchHeadName() {
	return branchHeadName;
}
public void setBranchHeadName(String branchHeadName) {
	this.branchHeadName = branchHeadName;
}
public double getBranchHeadSalary() {
	return branchHeadSalary;
}
public void setBranchHeadSalary(double branchHeadSalary) {
	this.branchHeadSalary = branchHeadSalary;
}
public long getBranchHeadPhone() {
	return branchHeadPhone;
}
public void setBranchHeadPhone(long branchHeadPhone) {
	this.branchHeadPhone = branchHeadPhone;
}
public int getBranchHeadExperience() {
	return branchHeadExperience;
}
public void setBranchHeadExperience(int branchHeadExperience) {
	this.branchHeadExperience = branchHeadExperience;
}


}
