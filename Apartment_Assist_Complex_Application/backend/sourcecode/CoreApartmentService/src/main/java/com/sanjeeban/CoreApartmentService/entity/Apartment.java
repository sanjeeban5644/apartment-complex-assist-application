package com.sanjeeban.CoreApartmentService.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "t_apartment", schema = "apt_core")
public class Apartment extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apartment_id")
    private Long apartmentId;

    @Column(name = "apartment_number", nullable = false, unique = true, length = 10)
    private String apartmentNumber;

    @Column(name = "type_code", nullable = false, length = 20)
    private String typeCode;

    @Column(name = "availability", nullable = false)
    private Boolean availability = true;

    @Column(name = "carpet_area", nullable = false, precision = 10, scale = 2)
    private BigDecimal carpetArea;

    public Long getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Long apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public BigDecimal getCarpetArea() {
        return carpetArea;
    }

    public void setCarpetArea(BigDecimal carpetArea) {
        this.carpetArea = carpetArea;
    }
}