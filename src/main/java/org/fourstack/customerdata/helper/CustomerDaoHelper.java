package org.fourstack.customerdata.helper;

import static org.fourstack.customerdata.codetype.CustomerStatus.INACTIVE;
import static org.fourstack.customerdata.codetype.AccountStatus.PENDING;
import static org.fourstack.customerdata.constants.CustomerConstants.DEFAULT_SRC_SYSTEM;
import static org.fourstack.customerdata.constants.CustomerConstants.END_YEAR;
import static org.fourstack.customerdata.constants.CustomerConstants.LAST_MONTH;
import static org.fourstack.customerdata.constants.CustomerConstants.LAST_DATE;
import static org.fourstack.customerdata.constants.CustomerConstants.HOUR_23;
import static org.fourstack.customerdata.constants.CustomerConstants.MINUTE_59;
import static org.fourstack.customerdata.constants.CustomerConstants.SECOND_59;

import org.fourstack.customerdata.dao.CustomerAccountRepository;
import org.fourstack.customerdata.dao.CustomerRepository;
import org.fourstack.customerdata.model.database.Customer;
import org.fourstack.customerdata.model.database.CustomerAccount;
import org.fourstack.customerdata.model.request.AccountCreationRequest;
import org.fourstack.customerdata.model.request.AccountInfoRequest;
import org.fourstack.customerdata.model.request.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomerDaoHelper {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerAccountRepository accountRepository;

    public void createCustomerAccountPartial(AccountCreationRequest request) {

        CustomerRequest customer = request.getCustomer();
        AccountInfoRequest customerAccountInfo = request.getCustomerAccountInfo();

        long customerId = saveCustomer(customer, request.getSrcSystem());
        saveCustomerAccountInfo(customerAccountInfo, request.getSrcSystem(), customerId);
    }

    private long saveCustomer(CustomerRequest customer, String sourceSystem) {
        Customer daoCustomer = new Customer();

        // Always set Customer Status to INACTIVE
        daoCustomer.setCustomerStatus(INACTIVE);

        daoCustomer.setCustomerType(customer.getCustomerType());
        daoCustomer.setCustomerSubType(customer.getCustomerSubType());
        daoCustomer.setCreateUser(sourceSystem != null ? sourceSystem : DEFAULT_SRC_SYSTEM);
        daoCustomer.setModifiedUser(sourceSystem != null ? sourceSystem : DEFAULT_SRC_SYSTEM);

        try {
            Customer savedCustomer = customerRepository.save(daoCustomer);
            return savedCustomer.getCustomerId();
        } catch (Exception e) {
            throw new RuntimeException("Unable to save Customer");
        }
    }

    private long saveCustomerAccountInfo(AccountInfoRequest customerAccountInfo, String sourceSystem, long customerId) {
        CustomerAccount daoAccount = new CustomerAccount();
        daoAccount.setCustomerId(customerId);
        daoAccount.setAccountNumber(customerAccountInfo.getAccountNumber());
        daoAccount.setAccountSystem(customerAccountInfo.getAccountSystem());
        // Always set Customer Status to PENDING
        daoAccount.setAccountStatus(PENDING);

        daoAccount.setAccountStartDate(LocalDateTime.now());
        daoAccount.setAccountEndDate(LocalDateTime.of(END_YEAR, LAST_MONTH, LAST_DATE, HOUR_23, MINUTE_59, SECOND_59));
        daoAccount.setCreateUser(sourceSystem != null ? sourceSystem : DEFAULT_SRC_SYSTEM);
        daoAccount.setModifiedUser(sourceSystem != null ? sourceSystem : DEFAULT_SRC_SYSTEM);

        try {
            CustomerAccount savedAccount = accountRepository.save(daoAccount);
            return savedAccount.getCustomerAccountId();
        } catch (Exception e) {
            throw new RuntimeException("Unable to save Customer Account Information");
        }
    }


}
