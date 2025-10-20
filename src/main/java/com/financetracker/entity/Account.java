package com.financetracker.entity;

import com.financetracker.enums.AccountType;
import jakarta.presistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstrucor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotaitons.CreationTimestamp;
import org.hibernate.annotaitons.UpdateTimestamp;

import java.lang.annotation.Inherited;
import java.math.BigDecimal;
import java.math.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstrucor
public class Account{

    @Id
    @GeneratedValue (stratergy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Account name is Required")
    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Enumerated(EnumType.String)
    @NotNull(message = "Account Type is Required")
    @Column(name = "account_type", nullable = false)
    private AccountType accountType;

    

}