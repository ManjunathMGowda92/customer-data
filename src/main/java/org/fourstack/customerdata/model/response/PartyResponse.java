package org.fourstack.customerdata.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.fourstack.customerdata.codetype.PartyType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyResponse {

    private long partyId;
    private PartyType partyType;
    private String firstName;
    private String lastName;
    private String orgName;
    private String primaryLocation;
    private String secondaryLocation;

    private List<ContactProfileResponse> contactProfiles;
    private List<AddressResponse> addresses;
}
