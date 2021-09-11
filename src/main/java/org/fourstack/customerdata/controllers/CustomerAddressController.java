package org.fourstack.customerdata.controllers;

import org.fourstack.customerdata.model.request.AddressRequest;
import org.fourstack.customerdata.model.response.CustomerDataResponse;
import org.fourstack.customerdata.services.CustomerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerAddressController {

    private final CustomerAddressService customerAddressService;

    @Autowired
    public CustomerAddressController (CustomerAddressService customerAddressService) {
        this.customerAddressService = customerAddressService;
    }

    @PostMapping(path = "/v1/customer/{customer-account-num}/address", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDataResponse> addCustomerAddress(@PathVariable("customer-account-num") String accountNum,
                                                                   @RequestBody AddressRequest address) {
        return new ResponseEntity <>(customerAddressService.addCustomerAddress(accountNum, address),
                HttpStatus.CREATED);
    }

    @PatchMapping(path = "/v1/customer/{customer-account-num}/address", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDataResponse> patchCustomerAddress(@PathVariable("customer-account-num") String accountNum,
                                                                     @RequestBody AddressRequest address) {
        return new ResponseEntity <>(customerAddressService.updateCustomerAddress(accountNum, address),
                HttpStatus.OK);
    }
}
