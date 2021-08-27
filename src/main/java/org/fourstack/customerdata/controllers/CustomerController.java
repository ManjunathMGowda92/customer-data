package org.fourstack.customerdata.controllers;

import org.fourstack.customerdata.model.request.AccountCreationRequest;
import org.fourstack.customerdata.model.request.CompleteAccountCreationRequest;
import org.fourstack.customerdata.model.request.RetrieveDataRequest;
import org.fourstack.customerdata.model.database.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@PostMapping("/v1/customers/retrieveCustomer")
	public String retrieveCustomerData(@RequestBody RetrieveDataRequest request){
		return "retrieveCustomerData";
	}
	
	@PostMapping("/v1/customers/createCustomerPartial")
	public String createCustomerData(@RequestBody AccountCreationRequest request){
		return "createCustomerData";
	}


	@PostMapping("/v1/customers/createCustomer")
	public String createCustomerDataComplete(@RequestBody CompleteAccountCreationRequest request){
		return "createCustomerData";
	}
	
	@PutMapping("/v1/customers/updateCustomer")
	public String updateCustomerData() {
		return "updateCustomerData";
	}
	
	@PatchMapping("/v1/customers/updateCustomer/{customer-id}")
	public String patchCustomerData(@PathVariable("customer-id") long customerId, @RequestBody Customer customer) {
		return "patchCustomerData";
	}
	
	@DeleteMapping("/v1/customers/deleteCustomer/{customer-id}")
	public String deleteCustomerData(@PathVariable("customer-id") long customerId) {
		return "deleteCustomerData";
	}

	@DeleteMapping("/v1/customers/{customer-account-num}")
	public String deleteCustomerByAccountNum(@PathVariable("customer-account-num") String accountNumber) {
		return "Delete Customer By Account Num";
	}

}
