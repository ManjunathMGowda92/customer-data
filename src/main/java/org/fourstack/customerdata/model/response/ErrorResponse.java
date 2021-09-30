package org.fourstack.customerdata.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse implements Serializable {
    private static final long serialVersionUID = 9205565618751027771L;

    @JsonProperty(value = "error_code")
    private int errorCode;

    @JsonProperty(value = "error_msg")
    private String errorMessage;

    @JsonProperty(value = "http_status")
    private HttpStatus status;

    @JsonProperty(value = "uri_details")
    private String urlDetails;

    @JsonProperty(value = "error_timestamp")
    private LocalDateTime timeStamp;
}
