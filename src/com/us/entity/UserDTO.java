package com.us.entity;

import java.sql.Date;

public class UserDTO {
    private long userId;
    private String name;
    private String password;

    private Date birth;
    private String address;
    private long majorId;
    private String role;
    private String status;

    public long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirth() {
        return birth;
    }

    public String getAddress() {
        return address;
    }

    public long getMajorId() {
        return majorId;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMajorId(long majorId) {
        this.majorId = majorId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
