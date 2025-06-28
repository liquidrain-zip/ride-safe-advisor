package com.smartrideadvisor.model;

public class WindSpeedApiResponse {
    private int code;
    private WindSpeedData data;
    private String errorMsg;

    // Getters and setters

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }

    public WindSpeedData getData() { return data; }
    public void setData(WindSpeedData data) { this.data = data; }

    public String getErrorMsg() { return errorMsg; }
    public void setErrorMsg(String errorMsg) { this.errorMsg = errorMsg; }
}
