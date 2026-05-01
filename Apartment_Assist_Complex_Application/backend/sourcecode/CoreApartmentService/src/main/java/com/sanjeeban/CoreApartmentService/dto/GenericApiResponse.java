package com.sanjeeban.CoreApartmentService.dto;

import java.time.LocalDateTime;

public class GenericApiResponse<T> {
    private String responseCode;
    private String responseMsg;
    private String responseStatus;
    private LocalDateTime timeStamp;
    private T apiData;

    public GenericApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public GenericApiResponse(String responseCode, String responseMsg, String responseStatus, LocalDateTime timeStamp, T apiData) {
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
        this.responseStatus = responseStatus;
        this.timeStamp = timeStamp;
        this.apiData = apiData;
    }

    public static <T> GenericApiResponse<T> success(T apiData){
        return new GenericApiResponse<>("200","SUCCESS","Data fetched", LocalDateTime.now(),apiData);
    }

    public static <T> GenericApiResponse<T> failure(String message){
        return new GenericApiResponse<>("400","FAILURE",message, LocalDateTime.now(),null);
    }


    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public T getApiData() {
        return apiData;
    }

    public void setApiData(T apiData) {
        this.apiData = apiData;
    }
}
