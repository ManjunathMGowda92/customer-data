package org.fourstack.customerdata.services;

import org.fourstack.customerdata.model.request.AddressRequest;

public interface CustomerAddressService {

    void addCustomerAddress(String accountNum, AddressRequest address);


}
