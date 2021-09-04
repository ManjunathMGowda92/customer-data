package org.fourstack.customerdata.controllers;

import org.fourstack.customerdata.model.request.AccountInfoRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerAccountController {

    @PatchMapping(path = "/v1/customer/{customer-account-num}/account", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String patchCustomerAccountData(@PathVariable("customer-account-num") String accountNum,
                                           @RequestBody AccountInfoRequest account) {
        return "Account Info Patched";
    }
}
