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
@Document(collection = "journal_entries")
public class Journal {
    @Id
    private String id;
    private String tenantId;
    private String journalNumber;
    private String description;
    private LocalDateTime entryDate;
    private String debitAccountCode;
    private String creditAccountCode;
    private BigDecimal amount;
    private String reference;
    private String status; // DRAFT, POSTED, REVERSED
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime postedAt;
    private LocalDateTime updatedAt;
}