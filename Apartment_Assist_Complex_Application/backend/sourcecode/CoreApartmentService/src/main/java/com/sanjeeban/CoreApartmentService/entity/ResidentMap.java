package com.sanjeeban.CoreApartmentService.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "t_resident_map", schema = "apt_core")
public class ResidentMap extends AuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="resident_id")
    private Long residentId;

    @Column(name = "unique_user_number",nullable = false)
    private String uniqueUserNumber;

    @Column(name = "apartment_number",nullable = false)
    private String apartmentNumber;

    public Long getResidentId() {
        return residentId;
    }

    public void setResidentId(Long residentId) {
        this.residentId = residentId;
    }

    public String getUniqueUserNumber() {
        return uniqueUserNumber;
    }

    public void setUniqueUserNumber(String uniqueUserNumber) {
        this.uniqueUserNumber = uniqueUserNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
}
