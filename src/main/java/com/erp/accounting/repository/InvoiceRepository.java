package com.erp.accounting.repository;

import com.erp.accounting.model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends MongoRepository<Invoice, String> {
    List<Invoice> findByTenantId(String tenantId);
    Optional<Invoice> findByInvoiceNumberAndTenantId(String invoiceNumber, String tenantId);
    List<Invoice> findByTenantIdAndInvoiceType(String tenantId, String invoiceType);
    List<Invoice> findByTenantIdAndStatus(String tenantId, String status);
    List<Invoice> findByTenantIdAndInvoiceDateBetween(String tenantId, LocalDateTime startDate, LocalDateTime endDate);
    List<Invoice> findByTenantIdAndPaymentStatus(String tenantId, String paymentStatus);
}