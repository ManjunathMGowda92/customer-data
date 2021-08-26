package org.fourstack.customerdata.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
	
	private long addressId;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String stateOrProvince;
	private String country;
	private String postalCode;
	private boolean isPrimaryAddress;
	
	
	private String createUser;
	private LocalDateTime createDate;
	private String modifiedUser;
	private LocalDateTime modifiedDate;

}
