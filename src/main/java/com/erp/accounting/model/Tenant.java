package com.erp.accounting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tenants")
public class Tenant {
    @Id
    private String id;
    private String name;
    private String code;
    private String industry;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String email;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean active;
}