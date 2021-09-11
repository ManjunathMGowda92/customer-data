package org.fourstack.customerdata.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressResponse {

    private long addressId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String stateOrProvince;
    private String country;
    private String postalCode;
    private boolean isPrimaryAddress;
}
