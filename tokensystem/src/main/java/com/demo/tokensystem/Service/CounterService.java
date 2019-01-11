package com.demo.tokensystem.Service;


import org.springframework.http.ResponseEntity;

public interface CounterService {

ResponseEntity<?> getToken(int counterNumber);

}
