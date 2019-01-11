package com.demo.tokensystem.Service;

import com.demo.tokensystem.Entity.TokenCustomer;
import com.demo.tokensystem.Repository.TokenCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class TokenCustomerServiceImpl implements TokenCustomerService {

    @Autowired
    private TokenCustomerRepository repository;


    @Override
    public TokenCustomer getTokenCustomer(String customerNumber) {
        return repository.findByCustomerNumber(customerNumber);
    }
}
