package org.fourstack.customerdata.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.fourstack.customerdata.codetype.ContactMediumSubType;
import org.fourstack.customerdata.codetype.ContactMediumType;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactProfile {
    private long contactId;
    private long customerId;
    private long partyId;
    private String contactName;
    private ContactMediumType contactMediumType;
    private ContactMediumSubType contactMediumSubType;


    private String createUser;
    private LocalDateTime createDate;
    private String modifiedUser;
    private LocalDateTime modifiedDate;

}
