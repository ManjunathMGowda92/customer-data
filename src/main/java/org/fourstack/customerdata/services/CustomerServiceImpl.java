package org.fourstack.customerdata.services;

import org.fourstack.customerdata.helper.CustomerDaoHelper;
import org.fourstack.customerdata.model.request.AccountCreationRequest;
import org.fourstack.customerdata.model.request.CompleteAccountCreationRequest;
import org.fourstack.customerdata.model.request.RetrieveDataRequest;
import org.fourstack.customerdata.model.response.CustomerDataResponse;
import org.fourstack.customerdata.model.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static org.fourstack.customerdata.constants.CustomerConstants.CUSTOMER_CREATED;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDaoHelper customerDaoHelper;

    @Override
    public List<CustomerResponse> retrieveCustomerData(RetrieveDataRequest request) {
        return null;
    }

    @Override
    public CustomerDataResponse createCustomerData(AccountCreationRequest request) {
        customerDaoHelper.createCustomerAccountPartial(request);

        return new CustomerDataResponse(HttpStatus.CREATED.value(),
                HttpStatus.CREATED.name(),
                CUSTOMER_CREATED,
                LocalDateTime.now(),
                "UNKNOWN");
    }

    @Override
    public CustomerDataResponse createCustomerDataComplete(CompleteAccountCreationRequest request) {
        return new CustomerDataResponse(HttpStatus.CREATED.value(),
                HttpStatus.CREATED.name(),
                CUSTOMER_CREATED,
                LocalDateTime.now(),
                "UNKNOWN");
    }
}
