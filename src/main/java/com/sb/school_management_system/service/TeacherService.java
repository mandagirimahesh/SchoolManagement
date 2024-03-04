package com.sb.school_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.school_management_system.dao.TeacherDao;
import com.sb.school_management_system.dto.School;
import com.sb.school_management_system.dto.Student;
import com.sb.school_management_system.dto.Teacher;
import com.sb.school_management_system.exception.TeacherIdNotFound;
import com.sb.school_management_system.util.ResponseStructure;

@Service
public class TeacherService {
@Autowired
TeacherDao teacherDao;

public ResponseEntity<ResponseStructure<Teacher>> saveTeacher(Teacher  teacher) {
	ResponseStructure<Teacher> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.CREATED.value());
	responseStructure.setMessage("Teacher succesfully inserted");
	responseStructure.setData(teacherDao.saveTeacher(teacher));
	return new ResponseEntity<ResponseStructure<Teacher>>(responseStructure,HttpStatus.CREATED);
}

public ResponseEntity<ResponseStructure<Teacher>> fetchTeacherById(int id) {
	if(teacherDao.fetchTeacherById(id)!=null) {
	ResponseStructure<Teacher> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.FOUND.value());
	responseStructure.setMessage("Teacher succesfully fetched");
	responseStructure.setData(teacherDao.fetchTeacherById(id));
	return new ResponseEntity<ResponseStructure<Teacher>>(responseStructure,HttpStatus.FOUND);
	}
	else {
		throw new TeacherIdNotFound();
	}
}

public ResponseEntity<ResponseStructure<Teacher>> deleteTeacher(int id) {
	if(teacherDao.fetchTeacherById(id)!=null) {
	ResponseStructure<Teacher> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Teacher succesfully deleted");
	responseStructure.setData(teacherDao.deleteTeacher(id));
	return new ResponseEntity<ResponseStructure<Teacher>>(responseStructure,HttpStatus.OK);
	}
	else {
		throw new TeacherIdNotFound();
	}
}

public ResponseEntity<ResponseStructure<Teacher>> updateTeacher(int id,Teacher teacher) {
	if(teacherDao.fetchTeacherById(id)!=null) {
	ResponseStructure<Teacher> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Teacher succesfully updated");
	responseStructure.setData(teacherDao.updateTeacher(id, teacher));
	return new ResponseEntity<ResponseStructure<Teacher>>(responseStructure,HttpStatus.OK);
	}
	else {
		throw new TeacherIdNotFound();
	}
}
}
