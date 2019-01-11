package com.demo.tokensystem.Service;

import com.demo.tokensystem.Model.Token;

public interface TokenGenService {

    Token generateToken(String customerNumber);
}
