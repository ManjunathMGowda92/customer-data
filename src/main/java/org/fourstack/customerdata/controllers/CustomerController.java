package org.fourstack.customerdata.controllers;

import org.fourstack.customerdata.model.request.AccountCreationRequest;
import org.fourstack.customerdata.model.request.CompleteAccountCreationRequest;
import org.fourstack.customerdata.model.request.RetrieveDataRequest;
import org.fourstack.customerdata.model.response.CustomerDataResponse;
import org.fourstack.customerdata.model.response.CustomerResponse;
import org.fourstack.customerdata.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/v1/customers/retrieveCustomer")
    public ResponseEntity<List<CustomerResponse>> retrieveCustomerData(@RequestBody RetrieveDataRequest request) {
        return new ResponseEntity<List<CustomerResponse>>(
                this.customerService.retrieveCustomerData(request),
                HttpStatus.OK
        );
    }

    @PostMapping("/v1/customers/createCustomerPartial")
    public ResponseEntity<CustomerDataResponse> createCustomerData(@RequestBody AccountCreationRequest request) {
        return new ResponseEntity<CustomerDataResponse>(
                this.customerService.createCustomerData(request),
                HttpStatus.CREATED
        );
    }


    @PostMapping("/v1/customers/createCustomer")
    public ResponseEntity<CustomerDataResponse> createCustomerDataComplete(@RequestBody CompleteAccountCreationRequest request) {
        return new ResponseEntity<CustomerDataResponse>(
                this.customerService.createCustomerDataComplete(request),
                HttpStatus.CREATED
        );
    }
	
	/*@PutMapping("/v1/customers/updateCustomer")
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
*/
}
