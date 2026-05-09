package com.erp.accounting.controller;

import com.erp.accounting.model.ChartOfAccount;
import com.erp.accounting.repository.ChartOfAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chart-of-accounts")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ChartOfAccountController {

    @Autowired
    private ChartOfAccountRepository chartOfAccountRepository;

    @GetMapping("/tenant/{tenantId}")
    public ResponseEntity<List<ChartOfAccount>> getAccountsByTenant(@PathVariable String tenantId) {
        List<ChartOfAccount> accounts = chartOfAccountRepository.findByTenantId(tenantId);
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChartOfAccount> getAccountById(@PathVariable String id) {
        Optional<ChartOfAccount> account = chartOfAccountRepository.findById(id);
        return account.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ChartOfAccount> createAccount(@RequestBody ChartOfAccount account) {
        ChartOfAccount saved = chartOfAccountRepository.save(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChartOfAccount> updateAccount(@PathVariable String id, @RequestBody ChartOfAccount account) {
        Optional<ChartOfAccount> existing = chartOfAccountRepository.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        account.setId(id);
        ChartOfAccount updated = chartOfAccountRepository.save(account);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String id) {
        chartOfAccountRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
