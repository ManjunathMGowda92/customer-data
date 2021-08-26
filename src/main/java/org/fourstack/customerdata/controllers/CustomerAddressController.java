package org.fourstack.customerdata.controllers;

import org.fourstack.customerdata.model.database.Address;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerAddressController {

    @PostMapping("/v1/customer/{customer-account-num}/address")
    public String addCustomerAddress(@PathVariable("customer-account-num") String accountNum,
                                     @RequestBody Address address) {
        return "Address Added";
    }

    @PatchMapping("/v1/customer/{customer-account-num}/address")
    public String patchCustomerAddress(@PathVariable("customer-account-num") String accountNum,
                                       @RequestBody Address address) {
        return "Address PATCH DONE";
    }
}
