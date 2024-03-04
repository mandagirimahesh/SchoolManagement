package com.sb.school_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.school_management_system.dao.StudentDao;
import com.sb.school_management_system.dto.School;
import com.sb.school_management_system.dto.Student;
import com.sb.school_management_system.dto.Teacher;
import com.sb.school_management_system.exception.StudentIdNotFound;
import com.sb.school_management_system.util.ResponseStructure;

@Service
public class StudentService {
@Autowired
StudentDao studentDao;

public ResponseEntity<ResponseStructure<Student>> saveStudent(Student  student) {
	ResponseStructure<Student> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.CREATED.value());
	responseStructure.setMessage("Student succesfully inserted");
	responseStructure.setData(studentDao.saveStudent(student));
	return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.CREATED);
}

public ResponseEntity<ResponseStructure<Student>> fetchStudentById(int id) {
	if(studentDao.fetchStudentById(id)!=null) {
	ResponseStructure<Student> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.FOUND.value());
	responseStructure.setMessage("Student succesfully fetched");
	responseStructure.setData(studentDao.fetchStudentById(id));
	return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.FOUND);
	}
	else {
		throw new StudentIdNotFound();
	}
}

public ResponseEntity<ResponseStructure<Student>> deleteStudent(int id) {
	if(studentDao.fetchStudentById(id)!=null) {
	ResponseStructure<Student> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Student succesfully deleted");
	responseStructure.setData(studentDao.deleteStudent(id));
	return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.OK) ;
	}
	else {
		throw new StudentIdNotFound();
	}
}

public ResponseEntity<ResponseStructure<Student>> updateStudent(int id,Student student) {
	if(studentDao.fetchStudentById(id)!=null) {
	ResponseStructure<Student> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Student succesfully updated");
	responseStructure.setData(studentDao.updateStudent(id, student));
	return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.OK);
	}
	else {
		throw new StudentIdNotFound(); 
	}
}
}
