package org.fourstack.customerdata.dao;

import org.fourstack.customerdata.codetype.AccountSystem;
import org.fourstack.customerdata.model.database.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {

    public Optional<CustomerAccount> findByAccountNumberAndAccountSystem(String accountNumber, AccountSystem accountSystem);
}
