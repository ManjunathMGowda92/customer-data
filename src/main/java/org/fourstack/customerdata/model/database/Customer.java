package org.fourstack.customerdata.model.database;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.fourstack.customerdata.codetype.CustomerStatus;
import org.fourstack.customerdata.codetype.CustomerSubType;
import org.fourstack.customerdata.codetype.CustomerType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "customer")
public class Customer {

	/**
	 * for customer_id, used sequence generator.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq")
	@SequenceGenerator(name = "customer_id_seq", initialValue = 1, sequenceName = "CUSTOMER_ID_SEQ", allocationSize = 1)
	@Column(name = "customer_id")
	private long customerId;

	@Column(name = "customer_status", length = 25, nullable = false)
	private CustomerStatus customerStatus;

	@Column(name = "customer_type", length = 25, nullable = false)
	private CustomerType customerType;

	@Column(name = "customer_subtype", length = 25, nullable = false)
	private CustomerSubType customerSubType;

	@JsonIgnore
	@Getter(value = AccessLevel.NONE)
	@Column(name = "create_usr")
	private String createUser;

	@JsonIgnore
	@Getter(value = AccessLevel.NONE)
	@CreationTimestamp
	@Column(name = "created_date", nullable = false, updatable = false)
	private LocalDateTime createDate;

	@JsonIgnore
	@Getter(value = AccessLevel.NONE)
	@Column(name = "mod_usr")
	private String modifiedUser;

	@JsonIgnore
	@Getter(value = AccessLevel.NONE)
	@UpdateTimestamp
	@Column(name = "mod_date", nullable = true, updatable = true)
	private LocalDateTime modifiedDate;

}
