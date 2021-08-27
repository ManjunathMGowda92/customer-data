package org.fourstack.customerdata.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.fourstack.customerdata.codetype.CustomerStatus;
import org.fourstack.customerdata.codetype.CustomerSubType;
import org.fourstack.customerdata.codetype.CustomerType;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerRequest {

    private CustomerStatus customerStatus;
    private CustomerType customerType;
    private CustomerSubType customerSubType;
}
