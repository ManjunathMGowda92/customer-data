package org.fourstack.customerdata.controllers;

import org.fourstack.customerdata.model.database.Party;
import org.fourstack.customerdata.model.request.PartyRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PartyController {

    @PostMapping("/v1/customer/{customer-account-num}/party")
    public String addCustomerPartyInfo(@PathVariable("customer-account-num") String accountNum,
                                       @RequestBody PartyRequest partyInfo) {
        return "Party Info added";
    }

    @PatchMapping("/v1/customer/{customer-account-num}/party")
    public String updateCustomerPartyInfo(@PathVariable("customer-account-num") String accountNum,
                                       @RequestBody PartyRequest partyInfo) {
        return "Party Info Updated";
    }
}
