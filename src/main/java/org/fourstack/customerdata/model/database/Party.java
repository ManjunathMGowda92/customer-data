package org.fourstack.customerdata.model.database;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.fourstack.customerdata.codetype.PartyType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "party",
    indexes = {
        @Index(
                name = "IDX_FIRST_LAST_NAME",
                unique = false,
                columnList = "first_name, last_name"
        ),
        @Index(
                name = "IDX_PRIMARY_LOCATION",
                unique = false,
                columnList = "primary_location"
        ),
        @Index(
                name = "IDX_SECONDARY_LOCATION",
                unique = false,
                columnList = "secondary_location"
            )
    }
)
public class Party {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "party_id_seq"
    )
    @SequenceGenerator(
            name = "party_id_seq",
            sequenceName = "PARTY_ID_SEQ",
            initialValue = 1,
            allocationSize = 1
    )
    private long partyId;

    @Column(name = "party_type", length = 25)
    private PartyType partyType;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name ="org_name")
    private String orgName;

    @Column(name = "primary_location")
    private String primaryLocation;

    @Column(name = "secondary_location")
    private String secondaryLocation;

    @Column(name = "create_usr", length = 50, nullable = false)
    private String createUser;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

    @Column(name ="mod_usr", length = 50)
    private String modifiedUser;

    @UpdateTimestamp
    @Column(name = "mod_date", nullable = true, updatable = true)
    private LocalDateTime modifiedDate;
}
