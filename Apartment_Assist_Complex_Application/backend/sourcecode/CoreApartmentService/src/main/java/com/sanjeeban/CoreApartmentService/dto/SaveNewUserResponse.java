package com.sanjeeban.CoreApartmentService.dto;


public class SaveNewUserResponse {

    private String uniqueUserNumber;
    private String remarks;

    public SaveNewUserResponse() {
    }

    public String getUniqueUserNumber() {
        return uniqueUserNumber;
    }

    public void setUniqueUserNumber(String uniqueUserNumber) {
        this.uniqueUserNumber = uniqueUserNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
