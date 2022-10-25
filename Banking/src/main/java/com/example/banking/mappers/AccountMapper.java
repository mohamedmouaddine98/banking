package com.example.banking.mappers;

import com.example.banking.DTO.BankAccountResponseDTO;
import com.example.banking.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO= new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
