package com.example.banking.service;

import com.example.banking.DTO.BankAccountRequestDTO;
import com.example.banking.DTO.BankAccountResponseDTO;
import com.example.banking.entities.BankAccount;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
