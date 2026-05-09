package com.erp.accounting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.erp.accounting")
public class AccountingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountingSystemApplication.class, args);
    }

}