package org.fourstack.customerdata.controllers;

import static org.fourstack.customerdata.constants.CustomerConstants.ADDRESS_CREATED;
import static org.fourstack.customerdata.constants.CustomerConstants.ADDRESS_UPDATED;

import org.fourstack.customerdata.model.request.AddressRequest;
import org.fourstack.customerdata.model.response.CustomerDataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class CustomerAddressController {

    @PostMapping("/v1/customer/{customer-account-num}/address")
    public ResponseEntity<CustomerDataResponse> addCustomerAddress(@PathVariable("customer-account-num") String accountNum,
                                             @RequestBody AddressRequest address) {
        return new ResponseEntity <>(new CustomerDataResponse(HttpStatus.CREATED.value(),
                HttpStatus.CREATED.name(),
                ADDRESS_CREATED,
                LocalDateTime.now(),
                "UNKNOWN"), HttpStatus.CREATED);
    }

    @PatchMapping("/v1/customer/{customer-account-num}/address")
    public ResponseEntity<CustomerDataResponse> patchCustomerAddress(@PathVariable("customer-account-num") String accountNum,
                                       @RequestBody AddressRequest address) {
        return new ResponseEntity <>(new CustomerDataResponse(HttpStatus.CREATED.value(),
                HttpStatus.OK.name(),
                ADDRESS_UPDATED,
                LocalDateTime.now(),
                "UNKNOWN"), HttpStatus.OK);
    }
}
