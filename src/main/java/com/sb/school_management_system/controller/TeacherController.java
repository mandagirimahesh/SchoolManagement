package com.sb.school_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.school_management_system.dto.Teacher;
import com.sb.school_management_system.service.TeacherService;
import com.sb.school_management_system.util.ResponseStructure;

@RestController
public class TeacherController {
@Autowired
TeacherService teacherService;

@PostMapping("/saveTeacher")
public ResponseEntity<ResponseStructure<Teacher>> saveTeacher(@RequestBody Teacher  teacher) {
	return teacherService.saveTeacher(teacher);
}

@GetMapping("/fetchTeacherById")
public ResponseEntity<ResponseStructure<Teacher>> fetchTeacherById(int id) {
	return teacherService.fetchTeacherById(id);
}

@DeleteMapping("/deleteTeacher")
public ResponseEntity<ResponseStructure<Teacher>> deleteTeacher(int id) {
	return teacherService.deleteTeacher(id);
}

@PutMapping("/updateTeacher")
public ResponseEntity<ResponseStructure<Teacher>> updateTeacher(int id,@RequestBody Teacher teacher) {
	return teacherService.updateTeacher(id, teacher);
}
}
