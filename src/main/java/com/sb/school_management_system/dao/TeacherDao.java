package com.sb.school_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.school_management_system.dto.Student;
import com.sb.school_management_system.dto.Teacher;
import com.sb.school_management_system.repo.TeacherRepo;

@Repository
public class TeacherDao {
@Autowired
TeacherRepo teacherRepo;


public Teacher saveTeacher(Teacher  teacher) {
	return teacherRepo.save(teacher);
}

public Teacher fetchTeacherById(int id) {
	Optional<Teacher> teacher=teacherRepo.findById(id);
	if(teacher.isPresent()) {
	return teacher.get();
	}
	else {
		return null;
	}
}

public Teacher deleteTeacher(int id) {
	Teacher teacher=fetchTeacherById(id);
	teacherRepo.delete(teacher);
	return teacher;
}

public Teacher updateTeacher(int id,Teacher teacher) {
	teacher.setTeacherId(id);
	return teacherRepo.save(teacher);
}
}
