package org.fourstack.customerdata.model.database;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.fourstack.customerdata.codetype.PartyType;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Party {

    private long partyId;
    private PartyType partyType;
    private String firstName;
    private String lastName;
    private String orgName;
    private String primaryLocation;
    private String secondaryLocation;

    private String createUser;
    private LocalDateTime createDate;
    private String modifiedUser;
    private LocalDateTime modifiedDate;
}
