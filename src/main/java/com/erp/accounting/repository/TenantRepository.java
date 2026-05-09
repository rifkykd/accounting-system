package com.erp.accounting.repository;

import com.erp.accounting.model.Tenant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TenantRepository extends MongoRepository<Tenant, String> {
    Optional<Tenant> findByCode(String code);
    Optional<Tenant> findByName(String name);
}