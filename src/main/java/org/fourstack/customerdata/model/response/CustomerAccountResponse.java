package org.fourstack.customerdata.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.fourstack.customerdata.codetype.AccountStatus;
import org.fourstack.customerdata.codetype.AccountSystem;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerAccountResponse {

    private long customerAccountId;
    private long customerId;
    private String accountNumber;
    private AccountSystem accountSystem;
    private AccountStatus accountStatus;
    private LocalDateTime accountStartDate;
    private LocalDateTime accountEndDate;
}
