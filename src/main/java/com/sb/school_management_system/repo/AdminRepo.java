package com.sb.school_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.school_management_system.dto.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

}
