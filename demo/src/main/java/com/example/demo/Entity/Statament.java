package com.example.demo.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Statament {

    @Id
    @Column(name="STATEMENT_ID")
    @GeneratedValue
    private Integer sId;
    @Column(name="ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name="AMOUNT_TYPE")
    private String amountType;
    @Column(name="AMOUNT")
    private Double amount;
    @Column(name="TRANSACTION_DATE")
    private LocalDateTime transactionDate;
    @Transient
    private Double currentBalance;

    public Integer getSId() {
        return this.sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAmountType() {
        return this.amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getCurrentBalance() {
        return this.currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }


}
