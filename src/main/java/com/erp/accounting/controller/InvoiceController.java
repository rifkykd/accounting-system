package com.erp.accounting.controller;

import com.erp.accounting.model.Invoice;
import com.erp.accounting.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/invoices")
@CrossOrigin(origins = "*", maxAge = 3600)
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @GetMapping("/tenant/{tenantId}")
    public ResponseEntity<List<Invoice>> getInvoicesByTenant(@PathVariable String tenantId) {
        List<Invoice> invoices = invoiceRepository.findByTenantId(tenantId);
        return ResponseEntity.ok(invoices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable String id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        return invoice.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        Invoice saved = invoiceRepository.save(invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable String id, @RequestBody Invoice invoice) {
        Optional<Invoice> existing = invoiceRepository.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        invoice.setId(id);
        Invoice updated = invoiceRepository.save(invoice);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable String id) {
        invoiceRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
