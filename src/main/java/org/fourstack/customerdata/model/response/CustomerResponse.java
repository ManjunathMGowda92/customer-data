package org.fourstack.customerdata.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fourstack.customerdata.model.database.Customer;
import org.fourstack.customerdata.model.database.CustomerAccount;
import org.fourstack.customerdata.model.database.Party;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse {

    private Customer customer;
    private CustomerAccountResponse customerAccount;
    private PartyResponse party;
}
