package com.sanjeeban.CoreApartmentService.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_complaint_master", schema = "apt_core")
public class ComplaintMaster extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaint_id")
    private Long complaintId;

    @Column(name = "complaint_code", nullable = false, unique = true, length = 20)
    private String complaintCode;

    @Column(name = "complaint_desc", nullable = false, length = 150)
    private String complaintDesc;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplaintCode() {
        return complaintCode;
    }

    public void setComplaintCode(String complaintCode) {
        this.complaintCode = complaintCode;
    }

    public String getComplaintDesc() {
        return complaintDesc;
    }

    public void setComplaintDesc(String complaintDesc) {
        this.complaintDesc = complaintDesc;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}