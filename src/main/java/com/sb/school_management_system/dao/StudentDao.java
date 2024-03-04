package com.sb.school_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.school_management_system.dto.Student;
import com.sb.school_management_system.repo.StudentRepo;


@Repository
public class StudentDao {
@Autowired
StudentRepo studentRepo;

public Student saveStudent(Student  student) {
	return studentRepo.save(student);
}

public Student fetchStudentById(int id) {
	Optional<Student> student=studentRepo.findById(id);
	if(student.isPresent()) {
	return studentRepo.findById(id).get();
	}
	else {
		return null;
	}
}

public Student deleteStudent(int id) {
	Student student=fetchStudentById(id);
	studentRepo.delete(student);
	return student;
}

public Student updateStudent(int id,Student student) {
	student.setStudentId(id);
	return studentRepo.save(student);
}
 
}
