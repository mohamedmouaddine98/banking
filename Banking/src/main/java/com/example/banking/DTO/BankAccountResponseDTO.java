package com.example.banking.DTO;

import com.example.banking.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {

        private String id;
        private Date createdAt;
        private Double balance;
        private String currency;
        private AccountType type;


}
