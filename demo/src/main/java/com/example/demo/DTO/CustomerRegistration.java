package com.example.demo.DTO;

import java.math.BigInteger;

public class CustomerRegistration {

    private String customerName;
    private String email;
    private BigInteger phone;
    private String houseNumber;
    private String area;
    private String city;
    private Long pincode;
    private String state;


    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPincode() {
        return this.pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
