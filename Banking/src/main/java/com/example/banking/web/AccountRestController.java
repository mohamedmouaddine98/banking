package com.example.banking.web;

import com.example.banking.DTO.BankAccountRequestDTO;
import com.example.banking.DTO.BankAccountResponseDTO;
import com.example.banking.Repository.BankAccountRepository;
import com.example.banking.entities.BankAccount;
import com.example.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@RequestMapping("/api")
@RestController
public class AccountRestController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
@GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){
        return accountService.addAccount(requestDTO);
    }
    @PostMapping("/bankAccounts/{id}")

    public BankAccount update(@PathVariable String id,BankAccount bankAccount){
        BankAccount account=bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
       if (bankAccount.getBalance()!=null) account.setBalance((bankAccount.getBalance()));
       if (bankAccount.getCreatedAt()!=null) account.setCreatedAt(new Date());
       if (bankAccount.getType()!=null) account.setType(bankAccount.getType());
       if (bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(bankAccount);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id){
         bankAccountRepository.deleteById(id);
    }
}
