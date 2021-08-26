package org.fourstack.customerdata.model.database;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.fourstack.customerdata.codetype.CustomerStatus;
import org.fourstack.customerdata.codetype.CustomerSubType;
import org.fourstack.customerdata.codetype.CustomerType;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
