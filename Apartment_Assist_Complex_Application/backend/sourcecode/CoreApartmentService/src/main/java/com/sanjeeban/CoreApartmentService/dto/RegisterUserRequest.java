package com.sanjeeban.CoreApartmentService.dto;

public class RegisterUserRequest {
    private String uniqueUserNumber;
    private String registerTo;

    public RegisterUserRequest() {
    }

    public String getUniqueUserNumber() {
        return uniqueUserNumber;
    }

    public void setUniqueUserNumber(String uniqueUserNumber) {
        this.uniqueUserNumber = uniqueUserNumber;
    }

    public String getRegisterTo() {
        return registerTo;
    }

    public void setRegisterTo(String registerTo) {
        this.registerTo = registerTo;
    }
}
