package org.fourstack.customerdata.model.database;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.fourstack.customerdata.codetype.ContactMediumSubType;
import org.fourstack.customerdata.codetype.ContactMediumType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(
        name = "contact_profile",
        uniqueConstraints = {
                @UniqueConstraint(name = "contact_medium_value_unique",
                columnNames = "contact_medium_value")
        },
        indexes = @Index(
                name = "IDX_CONTACT_VALUE",
                unique = true,
                columnList = "contact_medium_type, contact_medium_value"
        )
)
public class ContactProfile {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "contact_id_seq"
    )
    @SequenceGenerator(
            name = "contact_id_seq",
            sequenceName = "CONTACT_ID_SEQ",
            initialValue = 1,
            allocationSize = 1
    )
    private long contactId;

    @Column(name = "customer_id", nullable = false)
    private long customerId;

    @Column(name = "party_id", nullable = false)
    private long partyId;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_medium_type", length = 25, nullable = false)
    private ContactMediumType contactMediumType;

    @Column(name = "contact_medium_subtype", length = 25)
    private ContactMediumSubType contactMediumSubType;

    @Column(name = "contact_medium_value", nullable = false)
    private String contactMediumValue;

    @Column(name = "create_usr", length = 50)
    private String createUser;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

    @Column(name = "mod_usr", length = 50)
    private String modifiedUser;

    @UpdateTimestamp
    @Column(name = "mod_date", nullable = true, updatable = true)
    private LocalDateTime modifiedDate;

}
