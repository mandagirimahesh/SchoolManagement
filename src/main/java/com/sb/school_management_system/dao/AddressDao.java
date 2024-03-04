package com.sb.school_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.school_management_system.dto.Address;
import com.sb.school_management_system.dto.Admin;
import com.sb.school_management_system.repo.AddressRepo;

@Repository
public class AddressDao {
@Autowired
AddressRepo addressRepo;

public Address saveAddress(Address address) {
	return addressRepo.save(address);
}

public Address fetchAddressById(int id) {
	Optional<Address> address=addressRepo.findById(id);
	if(address.isPresent()) {
	return addressRepo.findById(id).get();
}
	else {
		return null;
	}
}

	
public Address deleteAddress(int id) {
	Address address=fetchAddressById(id);
	addressRepo.delete(address);
	return address;
}

public Address updateAddress(int id,Address address) {
	address.setAddressId(id);
	return addressRepo.save(address);
}
}
