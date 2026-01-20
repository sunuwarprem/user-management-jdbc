package com.prem.jdbc.model;

import java.util.Date;

public class User {

    private int id;
    private String username;
    private String password;
    private String address;
    private boolean status;
    private Date dateOfBirth;
    private Long mobileNo;

    public User() {
    }

    public User(String username, String password, String address, boolean status, Date dateOfBirth, Long mobileNo) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
        this.mobileNo = mobileNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }
}
