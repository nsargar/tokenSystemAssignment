package com.demo.tokensystem.Controller;

import com.demo.tokensystem.Entity.TokenCustomer;
import com.demo.tokensystem.Model.Token;
import com.demo.tokensystem.Service.TokenCustomerService;
import com.demo.tokensystem.Service.TokenGenService;
import com.demo.tokensystem.Utility.TokenUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@CrossOrigin
public class TokenGenController {

    @Autowired
    TokenGenService tokenGenService;

    @Autowired
    private TokenUtilities tokenUtilities;

    @Autowired
    TokenCustomerService tokenCustomerService;

    static final Logger logger= Logger.getLogger(TokenGenController.class.getName());

    @PostMapping("/generate")
    public ResponseEntity<?> generateToken(@RequestBody(required = false) String customerNumber){
        System.out.println("customerNumber : " + customerNumber);
        Token token = tokenGenService.generateToken(customerNumber);
        logger.info("Token : " + token);
        logger.info("numberOfCounters : " + tokenUtilities.numberOfCounters);
        logger.info("Token Counter : " + tokenUtilities.tokenCounter);
        logger.info("Token Non : " + tokenUtilities.nonPriviligedQueue.toString());
        logger.info("Token P : " + tokenUtilities.priviligedQueue.toString());
        ResponseEntity<Token> responseEntity=new ResponseEntity<Token>(token, HttpStatus.OK);

        return responseEntity;
    }
}
