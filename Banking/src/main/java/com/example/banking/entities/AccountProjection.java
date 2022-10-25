package com.example.banking.entities;

import com.example.banking.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

import static org.aspectj.apache.bcel.Constants.types;

@Projection(types =BankAccount.class, name = "p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();
}
