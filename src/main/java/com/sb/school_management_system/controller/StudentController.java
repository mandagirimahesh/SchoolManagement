package com.sb.school_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.school_management_system.dto.Student;
import com.sb.school_management_system.service.StudentService;
import com.sb.school_management_system.util.ResponseStructure;

@RestController
public class StudentController {
@Autowired
StudentService studentService;

@PostMapping("/saveStudent")
public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student  student) {
	return studentService.saveStudent(student);
}

@GetMapping("/fetchStudentById")
public ResponseEntity<ResponseStructure<Student>> fetchStudentById(int id) {
	return studentService.fetchStudentById(id);
}

@DeleteMapping("/deleteStudent")
public ResponseEntity<ResponseStructure<Student>> deleteStudent(int id) {
	return studentService.deleteStudent(id);
}

@PutMapping("/updateStudent")
public ResponseEntity<ResponseStructure<Student>> updateStudent(int id,@RequestBody Student student) {
	return studentService.updateStudent(id, student);
}
}
