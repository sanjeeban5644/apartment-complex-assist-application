package com.sanjeeban.CoreApartmentService.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_amenities_master", schema = "apt_core")
public class AmenitiesMaster extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amenity_id")
    private Long amenityId;

    @Column(name = "amenity_code", nullable = false, unique = true, length = 20)
    private String amenityCode;

    @Column(name = "amenity_desc", nullable = false, length = 100)
    private String amenityDesc;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    public Long getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(Long amenityId) {
        this.amenityId = amenityId;
    }

    public String getAmenityCode() {
        return amenityCode;
    }

    public void setAmenityCode(String amenityCode) {
        this.amenityCode = amenityCode;
    }

    public String getAmenityDesc() {
        return amenityDesc;
    }

    public void setAmenityDesc(String amenityDesc) {
        this.amenityDesc = amenityDesc;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}