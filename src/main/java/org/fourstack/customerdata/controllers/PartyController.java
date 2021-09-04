package org.fourstack.customerdata.controllers;

import org.fourstack.customerdata.model.request.PartyRequest;
import org.fourstack.customerdata.model.response.CustomerDataResponse;
import org.fourstack.customerdata.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PartyController {

    private final PartyService partyService;

    @Autowired
    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @PostMapping("/v1/customer/{customer-account-num}/party")
    public ResponseEntity<CustomerDataResponse> addCustomerPartyInfo(@PathVariable("customer-account-num") String accountNum,
                                                                     @RequestBody PartyRequest partyInfo) {
        return new ResponseEntity<CustomerDataResponse>(
                partyService.createPartyInfo(accountNum, partyInfo),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("/v1/customer/{customer-account-num}/party")
    public ResponseEntity<CustomerDataResponse> updateCustomerPartyInfo(@PathVariable("customer-account-num") String accountNum,
                                                                        @RequestBody PartyRequest partyInfo) {
        return new ResponseEntity<CustomerDataResponse>(
                partyService.updatePartyInfo(accountNum, partyInfo),
                HttpStatus.OK
        );
    }
}
