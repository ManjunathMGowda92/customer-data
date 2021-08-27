package org.fourstack.customerdata.controllers;

import org.fourstack.customerdata.model.database.ContactProfile;
import org.fourstack.customerdata.model.request.ContactRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ContactProfileController {

    @PostMapping("/v1/customer/{customer-account-num}/contact")
    public String addCustomerContactProfile(@PathVariable("customer-account-num") String accountNum,
                                              @RequestBody ContactRequest contactProfile){
        return "Customer Contact Added";
    }


    @PatchMapping("/v1/customer/{customer-account-num}/contact")
    public String patchCustomerContactProfile(@PathVariable("customer-account-num") String accountNum,
                                              @RequestBody ContactRequest contactProfile){
        return "Customer Contact Patch done";
    }
}
