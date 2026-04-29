package com.sanjeeban.CoreApartmentService.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_user_mapping",schema = "apt_core")
public class UserMapping extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_map_id")
    private Long userMapId;

    @Column(name = "unique_user_number", nullable = false, length = 20)
    private String uniqueUserNumber;

    @Column(name = "type_code", nullable = false, length = 20)
    private String typeCode;

    public Long getUserMapId() {
        return userMapId;
    }

    public void setUserMapId(Long userMapId) {
        this.userMapId = userMapId;
    }

    public String getUniqueUserNumber() {
        return uniqueUserNumber;
    }

    public void setUniqueUserNumber(String uniqueUserNumber) {
        this.uniqueUserNumber = uniqueUserNumber;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
}