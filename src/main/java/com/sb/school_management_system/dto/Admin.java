package com.sb.school_management_system.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	private String adminName;
	private String adminAddress;
	private double adminNetworth;
	private long adminPhone;

	@OneToOne(cascade = CascadeType.ALL)
	private School school;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}

	public double getAdminNetworth() {
		return adminNetworth;
	}

	public void setAdminNetworth(double adminNetworth) {
		this.adminNetworth = adminNetworth;
	}

	public long getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(long adminPhone) {
		this.adminPhone = adminPhone;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

}
