package org.fourstack.customerdata.controllers;

import org.fourstack.customerdata.model.database.CustomerAccount;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerAccountController {

    @PatchMapping("/v1/customer/{customer-account-num}/account")
    public String patchCustomerAccountData(@PathVariable("customer-account-num") String accountNum,
                                           @RequestBody CustomerAccount account) {
        return  "Account Info Patched";
    }
}
