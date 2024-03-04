package com.sb.school_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.school_management_system.dto.Address;
import com.sb.school_management_system.service.AddressService;
import com.sb.school_management_system.util.ResponseStructure;

@RestController
public class AddressController {
@Autowired
AddressService addressService;

@PostMapping("/saveAddress")
public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
	return addressService.saveAddress(address);
}

@GetMapping("/fetchAddressById")
public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int id) {
	return addressService.fetchAddressById(id);
}
	
@DeleteMapping("/deleteAddress")
public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) {
	return addressService.deleteAddress(id);
}

@PutMapping("/updateAddress")
public ResponseEntity<ResponseStructure<Address>> updateAddress(int id,@RequestBody Address address) {
	return addressService.updateAddress(id, address);
}
}
