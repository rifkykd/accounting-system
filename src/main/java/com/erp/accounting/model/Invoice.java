package com.erp.accounting.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;

@Document(collection = "invoices")
public class Invoice {
    @Id
    private String id;
    private String tenantId;
    private String invoiceNumber;
    private String invoiceType;
    private String customerVendorName;
    private String customerVendorId;
    private LocalDateTime invoiceDate;
    private LocalDateTime dueDate;
    private List<InvoiceLineItem> lineItems;
    private BigDecimal subtotal;
    private BigDecimal taxAmount;
    private BigDecimal total;
    private String status;
    private String paymentStatus;
    private BigDecimal paidAmount;
    private String currency;
    private String description;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime paidAt;

    public Invoice() {}

    public Invoice(String id, String tenantId, String invoiceNumber, String invoiceType, String customerVendorName, String customerVendorId, LocalDateTime invoiceDate, LocalDateTime dueDate, List<InvoiceLineItem> lineItems, BigDecimal subtotal, BigDecimal taxAmount, BigDecimal total, String status, String paymentStatus, BigDecimal paidAmount, String currency, String description, String createdBy, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime paidAt) {
        this.id = id;
        this.tenantId = tenantId;
        this.invoiceNumber = invoiceNumber;
        this.invoiceType = invoiceType;
        this.customerVendorName = customerVendorName;
        this.customerVendorId = customerVendorId;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.lineItems = lineItems;
        this.subtotal = subtotal;
        this.taxAmount = taxAmount;
        this.total = total;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.paidAmount = paidAmount;
        this.currency = currency;
        this.description = description;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.paidAt = paidAt;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }
    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }
    public String getInvoiceType() { return invoiceType; }
    public void setInvoiceType(String invoiceType) { this.invoiceType = invoiceType; }
    public String getCustomerVendorName() { return customerVendorName; }
    public void setCustomerVendorName(String customerVendorName) { this.customerVendorName = customerVendorName; }
    public String getCustomerVendorId() { return customerVendorId; }
    public void setCustomerVendorId(String customerVendorId) { this.customerVendorId = customerVendorId; }
    public LocalDateTime getInvoiceDate() { return invoiceDate; }
    public void setInvoiceDate(LocalDateTime invoiceDate) { this.invoiceDate = invoiceDate; }
    public LocalDateTime getDueDate() { return dueDate; }
    public void setDueDate(LocalDateTime dueDate) { this.dueDate = dueDate; }
    public List<InvoiceLineItem> getLineItems() { return lineItems; }
    public void setLineItems(List<InvoiceLineItem> lineItems) { this.lineItems = lineItems; }
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
    public BigDecimal getTaxAmount() { return taxAmount; }
    public void setTaxAmount(BigDecimal taxAmount) { this.taxAmount = taxAmount; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    public BigDecimal getPaidAmount() { return paidAmount; }
    public void setPaidAmount(BigDecimal paidAmount) { this.paidAmount = paidAmount; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public LocalDateTime getPaidAt() { return paidAt; }
    public void setPaidAt(LocalDateTime paidAt) { this.paidAt = paidAt; }
}

class InvoiceLineItem {
    private String description;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private BigDecimal amount;
    private String accountCode;

    public InvoiceLineItem() {}

    public InvoiceLineItem(String description, BigDecimal quantity, BigDecimal unitPrice, BigDecimal amount, String accountCode) {
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.accountCode = accountCode;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getQuantity() { return quantity; }
    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }
    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getAccountCode() { return accountCode; }
    public void setAccountCode(String accountCode) { this.accountCode = accountCode; }
}