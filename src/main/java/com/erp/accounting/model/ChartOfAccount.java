package com.erp.accounting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "chart_of_accounts")
public class ChartOfAccount {
    @Id
    private String id;
    private String tenantId;
    private String accountCode;
    private String accountName;
    private String accountType; // ASSET, LIABILITY, EQUITY, REVENUE, EXPENSE
    private String subType;
    private String description;
    private BigDecimal balance;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}