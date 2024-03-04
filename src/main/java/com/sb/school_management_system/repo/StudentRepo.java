package com.sb.school_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.school_management_system.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
