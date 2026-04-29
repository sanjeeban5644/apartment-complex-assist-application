package com.sanjeeban.CoreApartmentService.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_workflow_diary", schema = "apt_core")
public class WorkflowDiary extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workflow_id")
    private Long workflowId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "status_code", nullable = false, length = 20)
    private String statusCode;

    @Column(name = "complaint_id", nullable = false)
    private Long complaintId;

    public Long getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(Long workflowId) {
        this.workflowId = workflowId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }
}