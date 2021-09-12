package org.fourstack.customerdata.services;

import org.fourstack.customerdata.model.request.AccountCreationRequest;
import org.fourstack.customerdata.model.request.CompleteAccountCreationRequest;
import org.fourstack.customerdata.model.request.RetrieveDataRequest;
import org.fourstack.customerdata.model.response.CustomerDataResponse;
import org.fourstack.customerdata.model.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    List<CustomerResponse> retrieveCustomerData(RetrieveDataRequest request);

    CustomerDataResponse createCustomerData(AccountCreationRequest request);

    CustomerDataResponse createCustomerDataComplete (CompleteAccountCreationRequest request);
}
