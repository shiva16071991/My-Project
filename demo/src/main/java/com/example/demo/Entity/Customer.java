package com.example.demo.Entity;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private BigInteger phone;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getPhone() {
        return this.phone;
    }

    public void setPhone(BigInteger phone) {
        this.phone = phone;
    }

}
