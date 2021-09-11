package org.fourstack.customerdata.model.response;

import org.fourstack.customerdata.codetype.ContactMediumSubType;
import org.fourstack.customerdata.codetype.ContactMediumType;

public class ContactProfileResponse {

    private long contactId;
    private String contactName;
    private ContactMediumType contactMediumType;
    private ContactMediumSubType contactMediumSubType;
    private String contactMediumValue;

}
