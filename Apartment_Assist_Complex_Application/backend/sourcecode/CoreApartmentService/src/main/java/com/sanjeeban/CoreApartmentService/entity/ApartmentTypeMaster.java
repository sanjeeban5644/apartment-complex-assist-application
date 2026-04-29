package com.sanjeeban.CoreApartmentService.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_apartment_type_master", schema = "apt_core")
public class ApartmentTypeMaster extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long typeId;

    @Column(name = "type_code", nullable = false, unique = true, length = 20)
    private String typeCode;

    @Column(name = "type_desc", nullable = false, length = 100)
    private String typeDesc;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}