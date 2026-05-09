package com.sanjeeban.CoreApartmentService.dto;

import java.util.Map;

public class RegisterUserKafkaMessage {
    private Map<String,String> dataMap;

    public RegisterUserKafkaMessage() {
    }

    public Map<String, String> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, String> dataMap) {
        this.dataMap = dataMap;
    }
}
