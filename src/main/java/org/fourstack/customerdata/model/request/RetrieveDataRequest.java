package org.fourstack.customerdata.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetrieveDataRequest {
    private AccountCombination accountDetails;
    private NameCombination nameDetails;
    private ContactCombination contactDetails;
}
