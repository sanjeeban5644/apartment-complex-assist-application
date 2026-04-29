package com.sanjeeban.CoreApartmentService.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_complaint", schema = "apt_core")
public class Complaint extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaint_id")
    private Long complaintId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "complaint_code", nullable = false, length = 20)
    private String complaintCode;

    @Column(name = "priority", nullable = false, length = 10)
    private String priority; // LOW, MEDIUM, HIGH

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getComplaintCode() {
        return complaintCode;
    }

    public void setComplaintCode(String complaintCode) {
        this.complaintCode = complaintCode;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}