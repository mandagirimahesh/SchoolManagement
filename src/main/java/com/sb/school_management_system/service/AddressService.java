package com.sb.school_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.school_management_system.dao.AddressDao;
import com.sb.school_management_system.dto.Address;
import com.sb.school_management_system.dto.Admin;
import com.sb.school_management_system.exception.AddressIdNotFound;
import com.sb.school_management_system.util.ResponseStructure;

@Service
public class AddressService {
@Autowired
AddressDao addressDao;

public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
	ResponseStructure<Address> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.CREATED.value());
	responseStructure.setMessage("Admin succesfully inserted");
	responseStructure.setData(addressDao.saveAddress(address));
	return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.CREATED);
}

public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int id) {
	if(addressDao.fetchAddressById(id)!=null) {
	ResponseStructure<Address> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.FOUND.value());
	responseStructure.setMessage("Admin succesfully fetched");
	responseStructure.setData(addressDao.fetchAddressById(id));
	return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND) ;
	}
	else {
		throw new AddressIdNotFound();
	}
}
	
public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) {
	if(addressDao.fetchAddressById(id)!=null) {
	ResponseStructure<Address> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Admin succesfully deleted");
	responseStructure.setData(addressDao.deleteAddress(id));
	return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
	}
	else {
		throw new AddressIdNotFound();
	}
}

public ResponseEntity<ResponseStructure<Address>> updateAddress(int id,Address address) {
	if(addressDao.fetchAddressById(id)!=null) {
	ResponseStructure<Address> responseStructure=new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Admin succesfully updated");
	responseStructure.setData(addressDao.updateAddress(id,address));
	return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
	}
	else {
		throw new AddressIdNotFound();
	}
}
}
