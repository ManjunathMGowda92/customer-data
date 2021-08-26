package org.fourstack.customerdata.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetrieveDataRequest {

    private String customerAccountNumber;
    private String customerAccountSystem;
    private String firstName;
    private String lastName;
    private String contactMediumType;
    private String contactMediumValue;
}
