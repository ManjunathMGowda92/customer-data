package org.fourstack.customerdata.services;

import org.fourstack.customerdata.model.request.ContactRequest;
import org.fourstack.customerdata.model.response.CustomerDataResponse;

import java.util.List;

public interface ContactProfileService {

    /**
     * Method to create single contact / Multiple contact profiles based on the Customer Account Number provided.
     * Based on the list received the contact profiles will be created.
     *
     * @param accountNumber Account Number of a Customer
     * @param contactList   List of contact profiles need to be saved.
     * @return CustomerDataResponse Object with success or failure message.
     */
    CustomerDataResponse createContactProfiles(String accountNumber, List<ContactRequest> contactList);

    /**
     * Method to update single contact / Multiple contact profiles based on the Customer Account Number provided.
     * Contact profiles will be updated based on the List received content.
     *
     * @param accountNumber Account Number of a Customer
     * @param contactList   List of contact profiles need to be saved.
     * @return CustomerDataResponse Object with success or failure message.
     */
    CustomerDataResponse updateContactProfiles(String accountNumber, List<ContactRequest> contactList);

}
