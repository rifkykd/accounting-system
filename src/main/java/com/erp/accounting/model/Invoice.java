package com.erp.accounting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "invoices")
public class Invoice {
    @Id
    private String id;
    private String tenantId;
    private String invoiceNumber;
    private String invoiceType; // SALES, PURCHASE
    private String customerVendorName;
    private String customerVendorId;
    private LocalDateTime invoiceDate;
    private LocalDateTime dueDate;
    private List<InvoiceLineItem> lineItems;
    private BigDecimal subtotal;
    private BigDecimal taxAmount;
    private BigDecimal total;
    private String status; // DRAFT, ISSUED, PAID, OVERDUE, CANCELLED
    private String paymentStatus; // UNPAID, PARTIAL, PAID
    private BigDecimal paidAmount;
    private String currency;
    private String description;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime paidAt;
}

@Data
class InvoiceLineItem {
    private String description;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private BigDecimal amount;
    private String accountCode;
}