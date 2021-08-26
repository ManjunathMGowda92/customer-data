package org.fourstack.customerdata.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.fourstack.customerdata.codetype.AccountStatus;
import org.fourstack.customerdata.codetype.AccountSystem;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerAccount {
	
	private long customerAccountId;
	private long customerId;
	private String accountNumber;
	private AccountSystem accountSystem;
	private AccountStatus accountStatus;
	
	private LocalDateTime accountStartDate;
	private LocalDateTime accountEndDate;

	private String createUser;
	private LocalDateTime createDate;
	private String modifiedUser;
	private LocalDateTime modifiedDate;

}
