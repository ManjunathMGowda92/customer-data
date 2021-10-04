package org.fourstack.customerdata.controllers;

import org.fourstack.customerdata.model.request.ContactRequest;
import org.fourstack.customerdata.model.response.CustomerDataResponse;
import org.fourstack.customerdata.services.ContactProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactProfileController {

    @Autowired
    private ContactProfileService contactProfileService;

    @PostMapping("/v1/customer/{customer-account-num}/contact")
    public ResponseEntity<CustomerDataResponse> addCustomerContactProfile(
            @PathVariable("customer-account-num") String accountNum,
            @RequestBody List<ContactRequest> contactProfiles) {
        return new ResponseEntity<CustomerDataResponse>(
                contactProfileService.createContactProfiles(accountNum, contactProfiles),
                HttpStatus.CREATED
        );
    }


    @PatchMapping("/v1/customer/{customer-account-num}/contact")
    public ResponseEntity<CustomerDataResponse> patchCustomerContactProfile(
            @PathVariable("customer-account-num") String accountNum,
            @RequestBody List<ContactRequest> contactProfiles) {
        return new ResponseEntity<CustomerDataResponse>(
                contactProfileService.updateContactProfiles(accountNum, contactProfiles),
                HttpStatus.OK
        );
    }
}
