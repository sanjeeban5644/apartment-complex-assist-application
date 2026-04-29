package com.sanjeeban.CoreApartmentService.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "t_user_info", schema = "apt_core")
public class UserInfo extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @Column(name = "aadhar", nullable = false, unique = true, length = 12)
    private String aadhar;

    @Column(name = "mobile", nullable = false, unique = true, length = 10)
    private String mobile;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "unique_user_number", nullable = false, unique = true, length = 20)
    private String uniqueUserNumber;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUniqueUserNumber() {
        return uniqueUserNumber;
    }

    public void setUniqueUserNumber(String uniqueUserNumber) {
        this.uniqueUserNumber = uniqueUserNumber;
    }
}
