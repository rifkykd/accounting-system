package com.erp.accounting.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.math.BigDecimal;

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
    private String status;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime postedAt;
    private LocalDateTime updatedAt;

    public Journal() {}

    public Journal(String id, String tenantId, String journalNumber, String description, LocalDateTime entryDate, String debitAccountCode, String creditAccountCode, BigDecimal amount, String reference, String status, String createdBy, LocalDateTime createdAt, LocalDateTime postedAt, LocalDateTime updatedAt) {
        this.id = id;
        this.tenantId = tenantId;
        this.journalNumber = journalNumber;
        this.description = description;
        this.entryDate = entryDate;
        this.debitAccountCode = debitAccountCode;
        this.creditAccountCode = creditAccountCode;
        this.amount = amount;
        this.reference = reference;
        this.status = status;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.postedAt = postedAt;
        this.updatedAt = updatedAt;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }
    public String getJournalNumber() { return journalNumber; }
    public void setJournalNumber(String journalNumber) { this.journalNumber = journalNumber; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getEntryDate() { return entryDate; }
    public void setEntryDate(LocalDateTime entryDate) { this.entryDate = entryDate; }
    public String getDebitAccountCode() { return debitAccountCode; }
    public void setDebitAccountCode(String debitAccountCode) { this.debitAccountCode = debitAccountCode; }
    public String getCreditAccountCode() { return creditAccountCode; }
    public void setCreditAccountCode(String creditAccountCode) { this.creditAccountCode = creditAccountCode; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getPostedAt() { return postedAt; }
    public void setPostedAt(LocalDateTime postedAt) { this.postedAt = postedAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}