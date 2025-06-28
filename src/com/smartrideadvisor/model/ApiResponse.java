package com.smartrideadvisor.model;

public class ApiResponse {
    private int code;
    private DataWrapper data;
    private String errorMsg;

    // getters/setters
    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
    public DataWrapper getData() { return data; }
    public void setData(DataWrapper data) { this.data = data; }
    public String getErrorMsg() { return errorMsg; }
    public void setErrorMsg(String errorMsg) { this.errorMsg = errorMsg; }
}