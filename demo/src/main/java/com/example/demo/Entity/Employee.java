package com.example.demo.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name="EMPLOYEE_ID")
    private Integer eId;
    @Column(name="EMPLOYEE_NAME")
    private String eName;
    @Column(name="EMPLOYEE_SALARY")
    private BigDecimal eSalary;

    public Integer getEId() {
        return this.eId;
    }

    public void setEId(Integer eId) {
        this.eId = eId;
    }

    public String getEName() {
        return this.eName;
    }

    public void setEName(String eName) {
        this.eName = eName;
    }

    public BigDecimal getESalary() {
        return this.eSalary;
    }

    public void setESalary(BigDecimal eSalary) {
        this.eSalary = eSalary;
    }

}
