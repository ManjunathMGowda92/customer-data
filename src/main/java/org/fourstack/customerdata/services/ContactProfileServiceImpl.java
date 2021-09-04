package org.fourstack.customerdata.services;

import org.fourstack.customerdata.model.request.ContactRequest;
import org.fourstack.customerdata.model.response.CustomerDataResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactProfileServiceImpl implements ContactProfileService {

    @Override
    public CustomerDataResponse createContactProfiles(String accountNumber, List<ContactRequest> contactList) {
        return null;
    }

    @Override
    public CustomerDataResponse updateContactProfiles(String accountNumber, List<ContactRequest> contactList) {
        return null;
    }
}
