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
@Table(name = "contact_profile")
public class ContactProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long contactId;

    @Column(name = "customer_id", nullable = false)
    private long customerId;

    @Column(name = "party_id", nullable = false)
    private long partyId;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_medium_type", length = 25)
    private ContactMediumType contactMediumType;

    @Column(name = "contact_medium_subtype", length = 25)
    private ContactMediumSubType contactMediumSubType;

    @Column(name = "contact_medium_value")
    private String contactMediumValue;

    @Column(name = "create_usr")
    private String createUser;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

    @Column(name = "mod_usr")
    private String modifiedUser;

    @UpdateTimestamp
    @Column(name = "mod_date", nullable = true, updatable = true)
    private LocalDateTime modifiedDate;

}
