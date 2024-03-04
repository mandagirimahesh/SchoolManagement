package com.sb.school_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY )


private int addressId;
private int addressPlotNumber;
private String addressStreetName;
private String addressCity;
private String addressState;
private long addressPincode;
public int getAddressId() {
	return addressId;
}
public void setAddressId(int addressId) {
	this.addressId = addressId;
}
public int getAddressPlotNumber() {
	return addressPlotNumber;
}
public void setAddressPlotNumber(int addressPlotNumber) {
	this.addressPlotNumber = addressPlotNumber;
}
public String getAddressStreetName() {
	return addressStreetName;
}
public void setAddressStreetName(String addressStreetName) {
	this.addressStreetName = addressStreetName;
}
public String getAddressCity() {
	return addressCity;
}
public void setAddressCity(String addressCity) {
	this.addressCity = addressCity;
}
public String getAddressState() {
	return addressState;
}
public void setAddressState(String addressState) {
	this.addressState = addressState;
}
public long getAddressPincode() {
	return addressPincode;
}
public void setAddressPincode(long addressPincode) {
	this.addressPincode = addressPincode;
}


}
