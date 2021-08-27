package org.fourstack.customerdata.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.fourstack.customerdata.codetype.AccountStatus;
import org.fourstack.customerdata.codetype.AccountSystem;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountInfoRequest {

    private String accountNumber;
    private AccountSystem accountSystem;
    private AccountStatus accountStatus;

    private String srcSystem;
}
