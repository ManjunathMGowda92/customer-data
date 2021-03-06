package org.fourstack.customerdata.helper;

import org.fourstack.customerdata.converters.AccountSystemEnumConverter;
import org.fourstack.customerdata.dao.CustomerAccountRepository;
import org.fourstack.customerdata.dao.CustomerRepository;
import org.fourstack.customerdata.model.database.Customer;
import org.fourstack.customerdata.model.database.CustomerAccount;
import org.fourstack.customerdata.model.request.*;
import org.fourstack.customerdata.model.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.fourstack.customerdata.codetype.AccountStatus.PENDING;
import static org.fourstack.customerdata.codetype.CustomerStatus.INACTIVE;
import static org.fourstack.customerdata.constants.CustomerConstants.*;
import static org.fourstack.customerdata.util.CustomerDataUtil.isValidString;

@Component
public class CustomerDaoHelper {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerAccountRepository accountRepository;

    @Autowired
    private AccountSystemEnumConverter accountSystemEnumConverter;

    public void createCustomerAccountPartial(AccountCreationRequest request) {

        CustomerRequest customer = request.getCustomer();
        AccountInfoRequest customerAccountInfo = request.getCustomerAccountInfo();

        long customerId = saveCustomer(customer, request.getSrcSystem());
        saveCustomerAccountInfo(customerAccountInfo, request.getSrcSystem(), customerId);
    }

    public void retrieveCustomer(RetrieveDataRequest request) {
        AccountCombination accountDetails = request.getAccountDetails();
        NameCombination nameDetails = request.getNameDetails();
        ContactCombination contactDetails = request.getContactDetails();

        List<CustomerResponse> customerResponseList = new ArrayList<>();

        /* Fetch Customer based on Account Details i.e Account Number and Account System */
        if (accountDetails != null && isValidString(accountDetails.getCustomerAccountNumber())
                && isValidString(accountDetails.getCustomerAccountSystem())) {

            Optional<CustomerAccount> optionalCustomerAccount =
                    accountRepository.findByAccountNumberAndAccountSystem(
                            accountDetails.getCustomerAccountNumber(),
                            accountSystemEnumConverter.convertToEntityAttribute(accountDetails.getCustomerAccountSystem())
                    );

            if (optionalCustomerAccount.isPresent()) {
                System.out.println(optionalCustomerAccount.get());
            }
        }

        /* Fetch Customer based on Name Details i.e First name and Last name */
        if (nameDetails != null) {

        }

        /* Fetch Customer based on Contact Details i.e Contact Medium Type and Contact Medium Value */
        if (contactDetails != null) {

        }

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
