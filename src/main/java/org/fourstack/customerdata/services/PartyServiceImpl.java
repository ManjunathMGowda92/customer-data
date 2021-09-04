package org.fourstack.customerdata.services;

import org.fourstack.customerdata.model.request.PartyRequest;
import org.fourstack.customerdata.model.response.CustomerDataResponse;
import org.springframework.stereotype.Service;

@Service
public class PartyServiceImpl implements PartyService {
    @Override
    public CustomerDataResponse createPartyInfo(String accountNum, PartyRequest partyInfo) {
        return null;
    }

    @Override
    public CustomerDataResponse updatePartyInfo(String accountNum, PartyRequest partyInfo) {
        return null;
    }
}
