package com.sanjeeban.CoreApartmentService.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_workflow_status_master", schema = "apt_core")
public class WorkflowStatusMaster extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Long statusId;

    @Column(name = "status_code", nullable = false, unique = true, length = 20)
    private String statusCode;

    @Column(name = "status_desc", nullable = false, length = 100)
    private String statusDesc;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}