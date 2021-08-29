package org.fourstack.customerdata.services;

import org.fourstack.customerdata.model.request.AddressRequest;
import org.fourstack.customerdata.model.response.CustomerDataResponse;

public interface CustomerAddressService {

    CustomerDataResponse addCustomerAddress(String accountNum, AddressRequest address);

    CustomerDataResponse updateCustomerAddress(String accountNum, AddressRequest address);
}
