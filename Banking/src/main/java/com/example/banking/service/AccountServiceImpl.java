package com.example.banking.service;

import com.example.banking.DTO.BankAccountRequestDTO;
import com.example.banking.DTO.BankAccountResponseDTO;
import com.example.banking.Repository.BankAccountRepository;
import com.example.banking.entities.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service @Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount= BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
      BankAccount saveBankAccount =  bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO= BankAccountResponseDTO.builder()
                .id(saveBankAccount.getId())
                .type(saveBankAccount.getType())
                .createdAt(saveBankAccount.getCreatedAt())
                .currency(saveBankAccount.getCurrency())
                .balance(saveBankAccount.getBalance())
                .build();
         return bankAccountResponseDTO;
    }
}
