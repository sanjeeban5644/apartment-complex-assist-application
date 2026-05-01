package com.sanjeeban.CoreApartmentService.dto;

import java.util.Map;

public class UserTypeMasterResponse {
    Map<String,String> userTypeMasterMap;

    public UserTypeMasterResponse() {
    }

    public Map<String, String> getUserTypeMasterMap() {
        return userTypeMasterMap;
    }

    public void setUserTypeMasterMap(Map<String, String> userTypeMasterMap) {
        this.userTypeMasterMap = userTypeMasterMap;
    }
}
