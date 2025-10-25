package main.java.com.financetracker.entity;

import com.financetracker.enums.TransactionType;
import jakarta.presistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.lang.annotation.Inherited;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = transactions)
@Data
@NoArgsConstructor
@AllArgsConstrucor

public class Transactions {
    
    @Id
    @GenereatedValue(stratergy = GenerationType.IDENTITY)
    private Long id;

    @DecimalMin(value = "0.01", message = "Amount must be positive")
    @Column(name = "amount", precision = 15, scale = 2, nullable= false)
    private BidDecimal amount;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Transaction Type is required")
    @Column(name = "transaction_type", nullable = false)
    private String transactionType;

    @Columns(name = "description")
    private String description;

    @NotNull(message = "Transaction date is required")
    @column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updateable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false, updateable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_account_id")
    private Account fromAccount;

    @ManyToOne(fetch = DetchType.LAZY)
    @JoinColumn(name = "to_account_id")
    private Account toAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinCOlumn(name = "catogery_id")
    private Catogery catogery;
}
