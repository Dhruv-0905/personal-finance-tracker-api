package main.java.com.financetracker.entity;

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

import java.beans.ConstructorProperties;
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

    @DecimalMin(value = "0.0", inclusive = false, message = "Balance must be a positive")
    @Column(name = "balance", precision = 15, scale = 2, nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name = "account number", nullable = false, unique = true)
    private Long accountNumber;

    @Column(name = "bank name")
    private String bankName;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updateable = false)
    private LocalDateTime creationAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "fromAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transactions> outgoingTransactions = new ArrayList<>();

    @OneToMany(mappedBy = "toAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transactions> incomingTransactions = new ArrayList<>();

}