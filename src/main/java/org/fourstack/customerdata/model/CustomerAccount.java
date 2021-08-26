package org.fourstack.customerdata.model;

import java.time.LocalDateTime;

import org.fourstack.customerdata.codetype.AccountStatus;
import org.fourstack.customerdata.codetype.AccountSystem;

public class CustomerAccount {
	
	private long customerAccountId;
	private long customerId;
	private String accountNumber;
	private AccountSystem accountSystem;
	
	private LocalDateTime accountStartDate;
	private LocalDateTime accountEndDate;
	
	private AccountStatus accountStatus;
	
	
	private String createUser;
	private LocalDateTime createDate;
	private String modifiedUser;
	private LocalDateTime modifiedDate;

}
