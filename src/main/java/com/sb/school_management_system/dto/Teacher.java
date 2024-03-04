package com.sb.school_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Teacher {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private int teacherId;
private String teacherName;
private double teacherSalary;
private long teacherPhone;
private String teacherSubject;
private int teacherExperience;
public int getTeacherId() {
	return teacherId;
}
public void setTeacherId(int teacherId) {
	this.teacherId = teacherId;
}
public String getTeacherName() {
	return teacherName;
}
public void setTeacherName(String teacherName) {
	this.teacherName = teacherName;
}
public double getTeacherSalary() {
	return teacherSalary;
}
public void setTeacherSalary(double teacherSalary) {
	this.teacherSalary = teacherSalary;
}
public long getTeacherPhone() {
	return teacherPhone;
}
public void setTeacherPhone(long teacherPhone) {
	this.teacherPhone = teacherPhone;
}
public String getTeacherSubject() {
	return teacherSubject;
}
public void setTeacherSubject(String teacherSubject) {
	this.teacherSubject = teacherSubject;
}
public int getTeacherExperience() {
	return teacherExperience;
}
public void setTeacherExperience(int teacherExperience) {
	this.teacherExperience = teacherExperience;
}



}
