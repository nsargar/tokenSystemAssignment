package com.demo.tokensystem.Repository;

import com.demo.tokensystem.Entity.TokenCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenCustomerRepository extends JpaRepository<TokenCustomer,Long> {

    TokenCustomer findByCustomerNumber(String customerNumber);
}
