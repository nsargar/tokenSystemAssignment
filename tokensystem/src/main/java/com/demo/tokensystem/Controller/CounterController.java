package com.demo.tokensystem.Controller;

import com.demo.tokensystem.Model.Token;
import com.demo.tokensystem.Service.CounterService;
import com.demo.tokensystem.Utility.TokenUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CounterController {

    @Autowired
    private CounterService counterService;

    @GetMapping("/gettoken/{counterNumber}")
    public ResponseEntity<?> getToken(@PathVariable int counterNumber){
        return counterService.getToken(counterNumber);
    }
}
