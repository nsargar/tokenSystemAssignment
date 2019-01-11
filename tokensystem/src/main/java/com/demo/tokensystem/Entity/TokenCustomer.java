package com.demo.tokensystem.Entity;



import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TOKENCUSTOMER")
@Data
public class TokenCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenCustomerId;

    @Column(unique = true,length = 16)
    private String customerNumber;

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private boolean isPrivileged;

}
