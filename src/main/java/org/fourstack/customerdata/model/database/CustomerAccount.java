package org.fourstack.customerdata.model.database;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.fourstack.customerdata.codetype.AccountStatus;
import org.fourstack.customerdata.codetype.AccountSystem;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(
		name ="customer_account",
		uniqueConstraints = {
				@UniqueConstraint(name = "account_num_unique",
						columnNames = "account_num")
		},
		indexes = {
				@Index(
						name = "IDX_CUSTOMER_ACCOUNT",
						unique = true,
						columnList = "account_num"
				),
				@Index(
						name = "IDX_CUSTOMER_ACCT_SYS",
						unique = true,
						columnList = "account_num, account_system"
				)
		}
)
public class CustomerAccount {

	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "customer_account_id_seq"
	)
	@SequenceGenerator(
			name = "customer_account_id_seq",
			sequenceName = "CUSTOMER_ACCOUNT_ID_SEQ",
			initialValue = 1,
			allocationSize = 1
	)
	private long customerAccountId;

	@Column(name = "customer_id", nullable = false)
	private long customerId;

	@Column(name = "account_num", nullable = false, length = 25)
	private String accountNumber;

	@Column(name = "account_system", nullable = false, length = 25)
	private AccountSystem accountSystem;

	@Column(name = "account_status", nullable = false, length = 25)
	private AccountStatus accountStatus;

	@CreationTimestamp
	@Column(name = "account_start_date", nullable = false, updatable = false)
	private LocalDateTime accountStartDate;

	@CreationTimestamp
	@Column(name = "account_end_date", nullable = false, updatable = true)
	private LocalDateTime accountEndDate;

	@Column(name = "create_usr", length = 50)
	private String createUser;

	@CreationTimestamp
	@Column(name = "create_date", nullable = false, updatable = false)
	private LocalDateTime createDate;

	@Column(name = "mod_usr", length = 50)
	private String modifiedUser;

	@UpdateTimestamp
	@Column(name = "mod_date", nullable = true, updatable = true)
	private LocalDateTime modifiedDate;

}
