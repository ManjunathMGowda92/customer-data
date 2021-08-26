package org.fourstack.customerdata.model;

import java.time.LocalDateTime;

import org.fourstack.customerdata.codetype.CustomerStatus;
import org.fourstack.customerdata.codetype.CustomerSubType;
import org.fourstack.customerdata.codetype.CustomerType;

public class Customer {
	
	private long customerId;
	private CustomerStatus customerStatus;
	private CustomerType customerType;
	private CustomerSubType customerSubType;
	
	
	private String createUser;
	private LocalDateTime createDate;
	private String modifiedUser;
	private LocalDateTime modifiedDate;

}
