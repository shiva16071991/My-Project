package com.example.demo.Entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="ACCOUNT_NUMBER")
    private UUID accountNumber;

    @Column(name="ACCOUNT_NAME")
    private String accountName;

    @Column(name="ACCOUNT_TYPE")
    private String accountType;

    @Column(name="AMOUNT")
    private Double amount;

    public UUID getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(UUID accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


}
