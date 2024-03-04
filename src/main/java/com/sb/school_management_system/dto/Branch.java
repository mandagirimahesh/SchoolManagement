package com.sb.school_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Branch {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private int branchId;
private String branchName;
private long branchPhone;
private String branchEmail;
private String branchEstablishYear;

@OneToOne(cascade = CascadeType.ALL)
private BranchHead branchHead;

@OneToOne(cascade = CascadeType.ALL)
private Address address;

@OneToMany(cascade = CascadeType.ALL)
private List<Student> student;
@OneToMany(cascade = CascadeType.ALL)
private List<School> school;
@OneToMany(cascade = CascadeType.ALL)
private List<Teacher> teacher;

public int getBranchId() {
	return branchId;
}
public void setBranchId(int branchId) {
	this.branchId = branchId;
}
public String getBranchName() {
	return branchName;
}
public void setBranchName(String branchName) {
	this.branchName = branchName;
}
public long getBranchPhone() {
	return branchPhone;
}
public void setBranchPhone(long branchPhone) {
	this.branchPhone = branchPhone;
}
public String getBranchEmail() {
	return branchEmail;
}
public void setBranchEmail(String branchEmail) {
	this.branchEmail = branchEmail;
}
public String getBranchEstablishYear() {
	return branchEstablishYear;
}
public void setBranchEstablishYear(String branchEstablishYear) {
	this.branchEstablishYear = branchEstablishYear;
}
public BranchHead getBranchHead() {
	return branchHead;
}
public void setBranchHead(BranchHead branchHead) {
	this.branchHead = branchHead;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public List<Student> getStudent() {
	return student;
}
public void setStudent(List<Student> student) {
	this.student = student;
}
public List<School> getSchool() {
	return school;
}
public void setSchool(List<School> school) {
	this.school = school;
}
public List<Teacher> getTeacher() {
	return teacher;
}
public void setTeacher(List<Teacher> teacher) {
	this.teacher = teacher;
}







}
