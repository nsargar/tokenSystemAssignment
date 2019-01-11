package com.demo.tokensystem.Service;

import com.demo.tokensystem.Entity.TokenCustomer;
import com.demo.tokensystem.Model.Token;
import com.demo.tokensystem.Utility.TokenUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalTime;

@Service
public class TokenGenServiceImpl implements TokenGenService{

    @Autowired
    TokenCustomerService tokenCustomerService;

    @Autowired
    private TokenUtilities tokenUtilities;

    @Override
    public Token generateToken(String customerNumber) {
        System.out.println("Service cust : " + customerNumber);
        Token token = new Token();
        token.setTokenId("T" + String.valueOf(tokenUtilities.tokenCounter + 1));
        token.setGeneratedOn(LocalTime.now().toString());
        tokenUtilities.tokenCounter++;

        if(null == customerNumber || customerNumber.isEmpty()){
            tokenUtilities.nonPriviligedQueue.add(token);
        }
        else{
            TokenCustomer tokenGenCustomer = tokenCustomerService.getTokenCustomer(customerNumber);
            if(null != tokenGenCustomer && Boolean.TRUE == tokenGenCustomer.isPrivileged()){
                tokenUtilities.priviligedQueue.add(token);
            }else{
                tokenUtilities.nonPriviligedQueue.add(token);
            }
}
        return token;
    }
}
