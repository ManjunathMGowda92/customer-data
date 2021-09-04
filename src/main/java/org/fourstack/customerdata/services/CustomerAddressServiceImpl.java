package org.fourstack.customerdata.services;

import org.fourstack.customerdata.model.request.AddressRequest;
import org.fourstack.customerdata.model.response.CustomerDataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static org.fourstack.customerdata.constants.CustomerConstants.ADDRESS_CREATED;
import static org.fourstack.customerdata.constants.CustomerConstants.ADDRESS_UPDATED;

@Service
public class CustomerAddressServiceImpl implements  CustomerAddressService {

    @Override
    public CustomerDataResponse addCustomerAddress(String accountNum, AddressRequest address) {
        return new CustomerDataResponse(HttpStatus.CREATED.value(),
                HttpStatus.CREATED.name(),
                ADDRESS_CREATED,
                LocalDateTime.now(),
                "UNKNOWN");
    }

    @Override
    public CustomerDataResponse updateCustomerAddress(String accountNum, AddressRequest address) {
        return new CustomerDataResponse(HttpStatus.OK.value(),
                HttpStatus.OK.name(),
                ADDRESS_UPDATED,
                LocalDateTime.now(),
                null);
    }
}
