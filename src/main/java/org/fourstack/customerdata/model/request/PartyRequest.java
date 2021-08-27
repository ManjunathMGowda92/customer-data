package org.fourstack.customerdata.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.fourstack.customerdata.codetype.PartyType;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyRequest {

    private PartyType partyType;
    private String firstName;
    private String lastName;
    private String orgName;

    private List<ContactRequest> contactProfileList;

    private List<AddressRequest> addressList;

    private String srcSystem;
}
