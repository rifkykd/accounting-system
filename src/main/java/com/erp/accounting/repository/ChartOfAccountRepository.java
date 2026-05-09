package com.erp.accounting.repository;

import com.erp.accounting.model.ChartOfAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChartOfAccountRepository extends MongoRepository<ChartOfAccount, String> {
    List<ChartOfAccount> findByTenantId(String tenantId);
    Optional<ChartOfAccount> findByAccountCodeAndTenantId(String accountCode, String tenantId);
    List<ChartOfAccount> findByAccountTypeAndTenantId(String accountType, String tenantId);
    List<ChartOfAccount> findByTenantIdAndActive(String tenantId, boolean active);
}