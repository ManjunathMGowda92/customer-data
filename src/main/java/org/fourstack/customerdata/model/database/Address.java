package org.fourstack.customerdata.model.database;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_seq")
	@SequenceGenerator(name = "address_id_seq", sequenceName = "ADDRESS_ID_SEQ", initialValue = 1, allocationSize = 1)
	private long addressId;

	@Column(name = "address_line1")
	private String addressLine1;

	@Column(name = "address_line2")
	private String addressLine2;

	@Column(name = "city", length = 50)
	private String city;

	@Column(name = "state_or_province", length = 50)
	private String stateOrProvince;

	@Column(name = "country", length = 50)
	private String country;

	@Column(name = "postal_code", length = 10)
	private String postalCode;

	@Column(name = "is_primary_address")
	private boolean isPrimaryAddress;

	@Column(name = "create_usr", length = 50)
	private String createUser;

	@CreationTimestamp
	@Column(name = "created_date", nullable = false, updatable = false)
	private LocalDateTime createDate;

	@Column(name = "mod_usr", length = 50)
	private String modifiedUser;

	@Column(name = "mod_date", nullable = true, updatable = true)
	private LocalDateTime modifiedDate;

}
