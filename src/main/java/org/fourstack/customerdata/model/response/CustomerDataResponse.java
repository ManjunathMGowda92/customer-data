package org.fourstack.customerdata.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDataResponse {

    @JsonProperty("status_code")
    private int statusCode;

    @JsonProperty("status_message")
    private String statusMessage;

    @JsonProperty("message_desc")
    private String messageDescription;

    @JsonProperty("timestamp")
    private LocalDateTime timeStamp;

    @JsonProperty("src_system")
    private String srcSystem;
}
