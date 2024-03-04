package com.sb.school_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class School {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private int schoolId;
private String schoolName;
private long schoolPhone;
private String schoolEmail;
private String schoolWebsite;
@OneToMany(cascade = CascadeType.ALL)
private List<Branch> branch;

public int getSchoolId() {
	return schoolId;
}
public void setSchoolId(int schoolId) {
	this.schoolId = schoolId;
}
public String getSchoolName() {
	return schoolName;
}
public void setSchoolName(String schoolName) {
	this.schoolName = schoolName;
}
public long getSchoolPhone() {
	return schoolPhone;
}
public void setSchoolPhone(long schoolPhone) {
	this.schoolPhone = schoolPhone;
}
public String getSchoolEmail() {
	return schoolEmail;
}
public void setSchoolEmail(String schoolEmail) {
	this.schoolEmail = schoolEmail;
}
public String getSchoolWebsite() {
	return schoolWebsite;
}
public void setSchoolWebsite(String schoolWebsite) {
	this.schoolWebsite = schoolWebsite;
}
public List<Branch> getBranch() {
	return branch;
}
public void setBranch(List<Branch> branch) {
	this.branch = branch;
}





}
