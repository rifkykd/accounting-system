package com.erp.accounting.repository;

import com.erp.accounting.model.Journal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface JournalRepository extends MongoRepository<Journal, String> {
    List<Journal> findByTenantId(String tenantId);
    Optional<Journal> findByJournalNumberAndTenantId(String journalNumber, String tenantId);
    List<Journal> findByTenantIdAndStatus(String tenantId, String status);
    List<Journal> findByTenantIdAndEntryDateBetween(String tenantId, LocalDateTime startDate, LocalDateTime endDate);
    List<Journal> findByDebitAccountCodeAndTenantId(String accountCode, String tenantId);
}