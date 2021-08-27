package org.fourstack.customerdata.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.fourstack.customerdata.codetype.ContactMediumSubType;
import org.fourstack.customerdata.codetype.ContactMediumType;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactRequest {
    private String contactName;
    private ContactMediumType contactMediumType;
    private ContactMediumSubType contactMediumSubType;
    private String contactMediumValue;
}
