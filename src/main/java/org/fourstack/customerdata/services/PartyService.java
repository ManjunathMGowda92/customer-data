package org.fourstack.customerdata.services;

import org.fourstack.customerdata.model.request.PartyRequest;
import org.fourstack.customerdata.model.response.CustomerDataResponse;

public interface PartyService {

    /**
     * Method to create Party information based on the Customer Account Number.
     *
     * @param accountNum Account Number of Customer.
     * @param partyInfo  Party Information related to Customer.
     * @return CustomerDataResponse object with a success or failure message.
     */
    CustomerDataResponse createPartyInfo(String accountNum, PartyRequest partyInfo);

    /**
     * Method to update Party information based on the Customer Account Number.
     *
     * @param accountNum Account Number of Customer.
     * @param partyInfo  Party Information related to Customer.
     * @return CustomerDataResponse object with a success or failure message.
     */
    CustomerDataResponse updatePartyInfo(String accountNum, PartyRequest partyInfo);
}
