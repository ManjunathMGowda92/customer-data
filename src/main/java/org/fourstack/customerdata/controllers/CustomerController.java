package org.fourstack.customerdata.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	
	@GetMapping("/v1/test")
	public String test() {
		return "App is running!!!";
	}
	
	@GetMapping("/v1/customers/retrieveCustomer")
	public String retrieveCustomerData(){
		return "retrieveCustomerData";
	}
	
	@GetMapping("/v1/customers/createCustomer")
	public String createCustomerData(){
		return "createCustomerData";
	}
	
	@PutMapping("/v1/customers/updateCustomer")
	public String updateCustomerData() {
		return "updateCustomerData";
	}
	
	@PatchMapping("/v1/customers/updateCustomer")
	public String patchCustomerData() {
		return "patchCustomerData";
	}
	
	@DeleteMapping("/v1/customers/deleteCustomer")
	public String deleteCustomerData() {
		return "deleteCustomerData";
	}

}
