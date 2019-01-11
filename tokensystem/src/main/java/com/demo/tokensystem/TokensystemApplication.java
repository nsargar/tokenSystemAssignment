package com.demo.tokensystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TokensystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokensystemApplication.class, args);
	}

	/*@PostConstruct
	public static void createQueues(){
		System.out.println("In POST Construct");

	}*/

}

